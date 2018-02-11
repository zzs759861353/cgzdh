package com.cgzdh.buss.domain.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.TokenRequest;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cgzdh.buss.domain.dto.TUserDto;
import com.cgzdh.buss.domain.model.Agent;
import com.cgzdh.buss.domain.model.TUser;
import com.cgzdh.buss.domain.repository.AgentRepository;
import com.cgzdh.buss.domain.repository.TUserRepository;
import com.cgzdh.buss.exception.BusinessException;
import com.cgzdh.buss.exception.DbException;
import com.cgzdh.buss.util.ContextHolderUtils;
import com.cgzdh.buss.util.HttpClientHelper;
import com.cgzdh.buss.util.QrCodeUtil;
import com.cgzdh.buss.util.RandomSecurityCode;
import com.cgzdh.buss.util.SessionListener;
import com.cgzdh.buss.util.UUIDTool;
@Service
public class TUserService extends BaseService {
	Logger logger = LoggerFactory.getLogger(TUserService.class);
	@Autowired
	private TUserRepository tUserRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	BCryptPasswordEncoderService encoderService;
	@Autowired
	JedisConnectionFactory jedisConnectionFactory;
    @Value("qr.filePath")
    String filePath;
    @Value("agrementFilePath")
    String agrementFilePath;

	@Bean
	public TokenStore tokenStore() {
		return new RedisTokenStore(jedisConnectionFactory);
	}
	@PersistenceContext
	EntityManager em;

	// @Autowired
	// DefaultTokenServices tokenServices;	
	
	public List<TUserDto> getTUserDtoList() {
		return dozerUtil.map(tUserRepository.findAll(), TUserDto.class);
	}


	public TUserDto findByAccount(String userName) {
		List<TUser> tUserList = tUserRepository.findByUserName(userName);
		TUser tuser = new TUser();
		if (tUserList.size() > 0) {
			tuser = tUserList.get(0);
		}else{
			throw new BusinessException("此账户尚未注册");
		}
		return dozerUtil.map(tuser, TUserDto.class);
	}

	public void deleteTUser(String id) {
		tUserRepository.delete(id);
	}


	public TUserDto createTUser(TUserDto tUserDto) {
		TUser tuser = dozerUtil.map(tUserDto, TUser.class);
		if (tuser.getUserName().equals(tuser.getUserName())) { // 需要从协同平台提取数据
			
		}
		tuser.setSalt("e407ee90210cd677410b48649583b515");
		tuser.setPassword(encoderService.encryptPassword(tuser.getPassword()));
		TUser savedTUser = new TUser();
		try {
			savedTUser = tUserRepository.save(tuser);
		} catch (Exception e) {
			throw new BusinessException("保存数据失败");
		}

		return dozerUtil.map(savedTUser, TUserDto.class);

	}

	public OAuth2AccessToken checkAccount(TUserDto tUserDto) {
		TUserDto queryTUserDto = findByAccount(tUserDto.getUserName());
		if (encoderService.matches(tUserDto.getPassword(), queryTUserDto.getPassword())) {
			Authentication authentication = new UsernamePasswordAuthenticationToken(queryTUserDto,
					tUserDto.getPassword());
			ClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
			OAuth2RequestFactory oauth2RequestFactor = new DefaultOAuth2RequestFactory(clientDetailsService);
			ClientDetails client = new BaseClientDetails();
			Map<String, String> requestParameters = new HashMap<String, String>();
			String clientId = "";
			Collection<String> scope = new ArrayList<String>();
			String grantType = "OAuth2";
			TokenRequest tokenRequest = new TokenRequest(requestParameters, clientId, scope, grantType);
			OAuth2Request storedRequest = oauth2RequestFactor.createOAuth2Request(client, tokenRequest);
			OAuth2Authentication aAuth2Authentication = new OAuth2Authentication(storedRequest, authentication);
			final DefaultTokenServices tokenServices = new DefaultTokenServices();
			tokenServices.setTokenStore(tokenStore());
			OAuth2AccessToken oauth2AccessToken = tokenServices.createAccessToken(aAuth2Authentication);
			 Boolean hasLogin = SessionListener.checkIfHasLogin(queryTUserDto);

	           if(!hasLogin){  
	        	   HttpSession session = ContextHolderUtils.getSession();
                session.setAttribute("LOCAL_CLINET_USER", queryTUserDto);
	           SessionListener.addUserSession(session);  
	           return oauth2AccessToken;
	    } else{
	    	throw new BusinessException("该用户已经登陆");
	    }
	           
	           //return oauth2AccessToken;
			
		}
		throw new BusinessException("密码错误，请重新登陆");

	}
	public void layOut(){
		HttpSession session = ContextHolderUtils.getSession();
		SessionListener.removeSession(session.getId());
		session.invalidate();
	}
	//二维码
    public String getUserQr(TUser userDetails, String url) {
        try {
            String filePath = this.filePath+userDetails.getId()+".jpg";
            File files = new File(filePath);
            if(files.exists()){
               return filePath;
            }
            files.mkdirs();
           QrCodeUtil.encode(url+"/user/register?recommendId="+userDetails.getId()+"&agentId="+userDetails.getOrgId(), filePath);
           return filePath;
        } catch (Exception e) {
            logger.error("UserService.getUserQr has error",e);
            throw new DbException(500,"获取二维码过程报错！");
        }
    }

    /**
     * 普通用户注册
     * 设置该用户免费试用天数与推荐着免费试用天数
     * @param userVo
     */
    public TUser userRegister(TUserDto userVo){
    	Agent recomendAgent = null;
    	TUser recomendUser = null;
        if(!StringUtils.isEmpty(userVo.getRecommendId())){
            recomendAgent = agentRepository.findOne(userVo.getRecommendId());
            recomendUser = tUserRepository.findOne(userVo.getRecommendId());
        }
        TUser user = new TUser();
        BeanUtils.copyProperties(userVo, user);
        user.setPassword(encoderService.encryptPassword(user.getPassword()));
        user.setSalt(UUIDTool.getUUID());
        user.setId(UUIDTool.getUUID());
        Timestamp d = new Timestamp(System.currentTimeMillis()); 
        user.setCreateTime(d);
        user.setAmount(d);
        if(null != recomendAgent){
            user.setOrgId(recomendAgent.getId());
            user.setRecomender(recomendAgent.getName());
            //userMapper.delayPeriod(BigDecimal.valueOf(100),1,recomendUser.getId());
        }
        if(null != recomendUser){
        	user.setOrgId(recomendUser.getId());
        	user.setRecomender(recomendUser.getName());
        	//userMapper.delayPeriod(BigDecimal.valueOf(100),1,recomendUser.getId());
        }
        //user.setAmountActive(BigDecimal.valueOf(3));
       return tUserRepository.save(user);
    }

    /**
     * 机构代理商注册
     * 设置该用户免费试用天数与推荐着免费试用天数
     * @param userVo
     */
    public Agent agentRegister(Agent agent){
        agent.setId(UUIDTool.getUUID());
        agent.setAgreementFilePath(agrementFilePath+"/"+agent.getId()+".pdf");
        Timestamp d = new Timestamp(System.currentTimeMillis());
        agent.setCreateDate(d);
        return agentRepository.save(agent);
    }

    //验证码获取
    private final String LoginCode="code:login:{phone}";

    @Value("${service.winic}")
    private  String winicUrl;

    private final int retryNumber=3;

    private final String charset="GB2312";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getPhoneSmsByLogin(String phone) {
        String keys = String.format(LoginCode, phone);
        return (String) stringRedisTemplate.boundHashOps(keys).get(phone);
    }

    public String genLoginMsgCode(String phone) throws UnsupportedEncodingException {
        String keys = String.format(LoginCode, phone);
        RandomSecurityCode randomSecurityCode=  new RandomSecurityCode();
        String randCOde = randomSecurityCode.getRandNum();
        String url = String.format(winicUrl, phone, LocalDateTime.now().toString(),URLEncoder.encode("您好，您的验证码是"+randCOde, charset));
        String result = HttpClientHelper.create().executeForGET(url,retryNumber,charset);
        if(result.startsWith("")){
            stringRedisTemplate.boundHashOps(keys).put(phone,randCOde);
        }


        return randCOde;
    }
}

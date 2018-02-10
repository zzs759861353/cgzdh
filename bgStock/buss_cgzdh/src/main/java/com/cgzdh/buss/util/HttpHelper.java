package com.cgzdh.buss.util;

import com.cgzdh.buss.constant.Constants;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * @author v_bbojiang
 */
public final class HttpHelper {

    private static Logger logger = LoggerFactory.getLogger(HttpHelper.class);

    public static String execute(CloseableHttpClient httpClient, HttpUriRequest request){
        return HttpHelper.execute(httpClient,request, Constants.CHARSET);
    }

    public static String execute(CloseableHttpClient httpClient, HttpUriRequest request, String charset){

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            String str = EntityUtils.toString(entity,charset);
            return str;
        } catch (Exception e) {
            HttpHelper.logger.warn("execute http request fail,exception stacktrace is:\n {}", ExceptionUtils.getStackTrace(e));
            return null;
        }finally {
            try {
                if(response != null) {
                    response.close();
                }
            } catch (IOException e) {
                HttpHelper.logger.warn("close http response fail,exception stacktrace is:\n {}", ExceptionUtils.getStackTrace(e));
            }
        }
    }

    public static String generateBody(Map<String, String> map) {
        return HttpHelper.generateBody(map,Constants .CHARSET);
    }

    public static String generateBody(Map<String, String> map,String charset) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add( new BasicNameValuePair(entry.getKey(), entry.getValue()) );
        }
        return URLEncodedUtils.format(list, charset);
    }
}

package com.cgzdh.buss;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@EnableAuthorizationServer
@SpringBootApplication
@ComponentScan(basePackages = { "com.cgzdh.buss" })
@EntityScan(basePackages = { "com.cgzdh.buss.domain.model"})
@EnableJpaRepositories(basePackages = { "com.cgzdh.buss.domain.repository" })
@ServletComponentScan
public class BussApplication {

	public static void main(String[] args) {
		SpringApplication.run(BussApplication.class, args);
	}
	@Autowired
	JedisConnectionFactory jedisConnectionFactory;

	@Bean
	public TokenStore tokenStore() {
		return new RedisTokenStore(jedisConnectionFactory);
	}

	@Bean
	public DefaultTokenServices tokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}
}

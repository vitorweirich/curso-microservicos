package com.devsuperior.hroauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
public class AppConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
		jwt.setSigningKey("MY-SECRET-KEY");
		return jwt;
	}
	
	@Bean
	public JwtTokenStore tokenStore() {
		JwtTokenStore jwt = new JwtTokenStore(jwtAccessTokenConverter());
		return jwt;
	}
	
}

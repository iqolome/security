/**
 * 
 */
package com.ginger.sso.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Description: Sso授权服务配置
 * @author 姜锋
 * @date 2018年10月13日 下午9:00:44
 * @version V1.0
 */
@Configuration
@EnableAuthorizationServer
public class SsoAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(jwtTokenStore())
			.accessTokenConverter(jwtAccessTokenConverter());
	}
	
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		
		//访问tokenKey的时候需要身份认证
		security.tokenKeyAccess("isAuthenticated()");
	}
	
	/*
	 * 优化重构可参考
	 * @see com.ginger.security.app.GingerAuthorizationServerConfig.configure(
	 * ClientDetailsServiceConfigurer)
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/**
		 * authorizedGrantTypes: authorization_code password refresh_token Implicit
		 * client_credentials
		 */
		clients.inMemory()
			.withClient("ginger-client1")
			.secret("ginger-client1")
			.authorizedGrantTypes("authorization_code", "refresh_token")
			.scopes("all")
			.and()
			.withClient("ginger-client2")
			.secret("ginger-client2")
			.authorizedGrantTypes("authorization_code", "refresh_token")
			.scopes("all");
	}
	
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
		accessTokenConverter
			.setSigningKey("ginger");
		return accessTokenConverter;
	}
}

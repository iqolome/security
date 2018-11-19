/**
 * 
 */
package com.ginger.security.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.ginger.security.core.properties.OAuth2ClientProperties;
import com.ginger.security.core.properties.SecurityProperties;

/**
 * @Description: 认证服务配置
 * @author 姜锋
 * @date 2018年10月5日 下午5:52:20
 * @version V1.0
 */
@Configuration
@EnableAuthorizationServer
public class GingerAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	private TokenStore tokenStore;
	@Autowired(required = false)
	JwtAccessTokenConverter jwtAccessTokenConverter;
	@Autowired(required = false)
	TokenEnhancer jwtTokenEnhancer;
	
	
	/**
	 *   认证及token配置
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager)
				.userDetailsService(userDetailsService);
		if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
			TokenEnhancerChain enhancerChain = new TokenEnhancerChain();
			List<TokenEnhancer> enhancers = new ArrayList<>();
			enhancers.add(jwtTokenEnhancer);
			enhancers.add(jwtAccessTokenConverter);
			enhancerChain.setTokenEnhancers(enhancers);
			endpoints.tokenEnhancer(enhancerChain).accessTokenConverter(jwtAccessTokenConverter);
		}
	}
	

	/**
	 * tokenKey的访问权限表达式配置
	 */
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()");
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/**
		 * authorizedGrantTypes: authorization_code password refresh_token Implicit
		 * client_credentials
		 */
		// securityProperties
		/* clients.jdbc(dataSource); */
		InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
		if (ArrayUtils.isNotEmpty(securityProperties.getOauth2().getClients())) {
			for (OAuth2ClientProperties config : securityProperties.getOauth2().getClients()) {
				builder.withClient(config.getClientId()).secret(config.getClientSecret())
						// token有效期设置7200秒(约俩小时)
						.accessTokenValiditySeconds(config.getAccessTokenValiditySeconds())
						// 刷新token的有效期
						.refreshTokenValiditySeconds(2592000).authorizedGrantTypes("refresh_token", "password")
						.scopes("all");
			}
		}
	}
}

/**
 * 
 */
package com.ginger.security.core.social;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.SpringSocialConfigurer;

import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.social.support.GingerSpringSocialConfigurer;
import com.ginger.security.core.social.support.SocialAuthenticationFilterPostProcessor;

/**
 * @Description: 社会化登录配置
 * @author 姜锋
 * @date 2018年9月24日 下午4:55:57 
 * @version V1.0   
 *
 */
@Configuration
@EnableSocial
@Order(1)
public class SocialConfig extends SocialConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired(required = false)
	private ConnectionSignUp connectionSignUplp;
	
	@Autowired(required = false)
	private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

	
	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO 可设置加密算法
		//在此类旁边有建表的SQL
		JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
		//可设置表前缀
		repository.setTablePrefix("ginger_");
		if(connectionSignUplp != null) {
			repository.setConnectionSignUp(connectionSignUplp);
			
		}
		return repository;
	}
	
	
	/**
	 * 
	 * @Description: 社交登录配置类，供浏览器或app模块引入设计登录配置用
	 * @author 姜锋
	 * @date 2018年10月14日 下午4:35:45
	 * @param @return
	 * @return SpringSocialConfigurer
	 * @throws
	 */
	@Bean
	public SpringSocialConfigurer gingerSocialSecurityConfig() {
		
		String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
		GingerSpringSocialConfigurer configurer = new GingerSpringSocialConfigurer(filterProcessesUrl);
		configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
		configurer.setSocialAuthenticationFilterPostProcessor(socialAuthenticationFilterPostProcessor);
		return configurer;
	}
	
	/**
	 * 
	 * @Description: 用来处理注册流程的工具类
	 * @author 姜锋
	 * @date 2018年10月14日 下午4:35:34
	 * @param @param connectionFactoryLocator
	 * @param @return
	 * @return ProviderSignInUtils
	 * @throws
	 */
	@Bean
	public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator) {
		
		return new ProviderSignInUtils(connectionFactoryLocator,
				getUsersConnectionRepository(connectionFactoryLocator)) {
		};
	}
}

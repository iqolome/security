/**
 * 
 */
package com.ginger.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import com.ginger.security.core.authentication.FormAuthenticationConfig;
import com.ginger.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ginger.security.core.authorize.AuthorizeConfigManager;
import com.ginger.security.core.properties.SecurityConstants;
import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * @Description: 浏览器环境下安全配置主类
 * @author 姜锋
 * @date 2018年4月11日 下午10:39:36
 * @version V1.0
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Autowired
	private SpringSocialConfigurer gingerSocialSecurityConfig;
	
	@Autowired
	private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;
	
	@Autowired
	private InvalidSessionStrategy invalidSessionStrategy;
	
	@Autowired
	private LogoutSuccessHandler logoutSuccessHandler;
	
	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;
	
	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		formAuthenticationConfig.configure(http);		
		http.apply(validateCodeSecurityConfig)
			.and()
			.apply(smsCodeAuthenticationSecurityConfig)
			//增加SocialSecurityConfig配置有ginger-security-core提供com.ginger.security.core.social.SocialConfig
			.and()
			.apply(gingerSocialSecurityConfig)
			.and()
			//记住我配置，如果想在'记住我'登录时记录日志，可以注册一个InteractiveAuthenticationSuccessEvent事件的监听器
			.rememberMe()
				.tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
				.userDetailsService(userDetailsService)
			.and()
			
			.sessionManagement()
			.invalidSessionStrategy(invalidSessionStrategy)
			.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
			.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin())
			.expiredSessionStrategy(sessionInformationExpiredStrategy)
			.and()
			.and()
			.logout()
				/**
				 * 登出地址
				 */
				.logoutUrl(SecurityConstants.DEFAULT_SIGN_OUT_PROCESSING_URL)
				/**
				 * 登出处理逻辑
				 */
				.logoutSuccessHandler(logoutSuccessHandler)
				/**
				 * 删除Cookie
				 */
				.deleteCookies("JSESSIONID")
			.and()
			.csrf().disable();
		authorizeConfigManager.config(http.authorizeRequests());
		
	}

	
	
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}
}

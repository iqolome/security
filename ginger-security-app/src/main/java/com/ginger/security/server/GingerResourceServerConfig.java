/**
 * 
 */
package com.ginger.security.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SpringSocialConfigurer;

import com.ginger.security.app.authentication.openid.OpenIdAuthenticationSecurityConfig;
import com.ginger.security.core.authentication.FormAuthenticationConfig;
import com.ginger.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ginger.security.core.authorize.AuthorizeConfigManager;
import com.ginger.security.core.validate.code.ValidateCodeSecurityConfig;

/**
 * @Description: 资源服务器配置
 * @author 姜锋
 * @date 2018年10月6日 上午11:31:24
 * @version V1.0
 */
@Configuration
@EnableResourceServer
public class GingerResourceServerConfig extends ResourceServerConfigurerAdapter {
	@Autowired
	AuthenticationSuccessHandler gingerAuthenticationSuccessHandler;
	@Autowired
	AuthenticationFailureHandler gingerAuthenticationFailureHandler;
	@Autowired
	private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	@Autowired
	private SpringSocialConfigurer gingerSocialSecurityConfig;
	@Autowired
	private OpenIdAuthenticationSecurityConfig openIdAuthenticationSecurityConfig;
	@Autowired
	private AuthorizeConfigManager authorizeConfigManager;
	
	@Autowired
	private FormAuthenticationConfig formAuthenticationConfig;

	@Override
	public void configure(HttpSecurity http) throws Exception {
formAuthenticationConfig.configure(http);
		
		http.apply(validateCodeSecurityConfig)
				.and()
			.apply(smsCodeAuthenticationSecurityConfig)
				.and()
			.apply(gingerSocialSecurityConfig)
				.and()
			.apply(openIdAuthenticationSecurityConfig)
				.and()
			.csrf().disable();
		
		authorizeConfigManager.config(http.authorizeRequests());
	}
}

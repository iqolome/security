/**
 * 
 */
package com.ginger.security.core.authentication.mobile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Description: 短信登录配置
 * @author 姜锋
 * @date 2018年9月23日 下午6:54:12 
 * @version V1.0   
 *
 */

@Component
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	@Autowired
	private AuthenticationSuccessHandler gingerAuthenticationSuccessHandler;
	@Autowired
	private AuthenticationFailureHandler gingerAuthenctiationFailureHandler;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
	SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
	smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
	smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(gingerAuthenticationSuccessHandler);
	smsCodeAuthenticationFilter.setAuthenticationFailureHandler(gingerAuthenctiationFailureHandler);
	
	SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
	smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);
	
	http.authenticationProvider(smsCodeAuthenticationProvider)
		.addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
}

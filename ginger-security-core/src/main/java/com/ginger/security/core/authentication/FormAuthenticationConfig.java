/**
 * 
 */
package com.ginger.security.core.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.ginger.security.core.properties.SecurityConstants;

/**
 * @Description: 表单登录配置 
 * @author 姜锋
 * @date 2018年10月14日 下午3:10:57 
 * @version V1.0   
 *
 */
@Component
public class FormAuthenticationConfig {
	
	@Autowired
	protected AuthenticationSuccessHandler gingerAuthenticationSuccessHandler;
	
	@Autowired
	protected AuthenticationFailureHandler gingerAuthenticationFailureHandler;
	
	public void configure(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
			.successHandler(gingerAuthenticationSuccessHandler)
			.failureHandler(gingerAuthenticationFailureHandler);
	}
}

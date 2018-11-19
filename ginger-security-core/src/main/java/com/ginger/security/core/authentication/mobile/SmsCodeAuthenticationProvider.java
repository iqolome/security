/**
 * 
 */
package com.ginger.security.core.authentication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description: 短信登录验证逻辑
 * 由于短信验证码的验证在过滤器里已完成，这里直接读取用户信息即可。
 * @author 姜锋
 * @date 2018年9月23日 下午6:33:22 
 * @version V1.0   
 *
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider{
	
	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken)authentication;
		UserDetails user = userDetailsService.loadUserByUsername((String) authenticationToken.getPrincipal());
		if(user == null) {
			throw new InternalAuthenticationServiceException("无法获取用户信息");
		}
		SmsCodeAuthenticationToken authenticationTokenResult = new SmsCodeAuthenticationToken(user, user.getAuthorities());
		authenticationTokenResult.setDetails(authenticationToken.getDetails());
		return authenticationTokenResult;
	}

	
	@Override
	public boolean supports(Class<?> authentication) {
		//判断传入的是否是SmsCode类型
		return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
	}


	/**
	 * @return userDetailsService
	 */
	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}


	/**
	 * @param userDetailsService 要设置的 userDetailsService
	 */
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	
}

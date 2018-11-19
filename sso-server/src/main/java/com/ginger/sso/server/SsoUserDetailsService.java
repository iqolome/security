/**
 * 
 */
package com.ginger.sso.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Description: 用户信息
 * @author 姜锋
 * @date 2018年10月13日 下午11:12:18 
 * @version V1.0   
 *
 */
@Component
public class SsoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new User(username, passwordEncoder.encode("ginger"), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
	}
	
	
}

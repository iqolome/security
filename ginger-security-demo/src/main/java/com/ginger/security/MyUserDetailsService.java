/**
 * 
 */
package com.ginger.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import com.ginger.security.rbac.domain.Admin;
import com.ginger.security.rbac.repository.AdminRepository;

/**
 * @Description: 自定义用户认证逻辑
 * @author 姜锋
 * @date 2018年4月12日 上午8:26:36 
 * @version V1.0   
 *
 */
@Transactional
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService{

	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdminRepository adminRepository;

	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("表单登录用户名:" + username);
		Admin admin = adminRepository.findByUsername(username);
		admin.getUrls();
		return admin;
	}

	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		logger.info("社交登录用户ID:"+userId);
		return buildUser(userId);
	}

	/**
	 * @Description: 构建登录信息
	 * @author 姜锋
	 * @date 2018年9月24日 下午5:22:07
	 * @param @param username
	 * @param @return
	 * @return UserDetails
	 * @throws
	 */
	private SocialUserDetails buildUser(String username) {
		//根据用户名查找用户信息
				//1.用户名
				//2.密码
				//3.账户可用  (true 为可用) isEnabled : 主要用于用户是否被删除
				//4. 账户没有过期  (true 为没有过期)isAccountNonExpired
				//5.密码没有过期  (true 为没有过期) isCredentialsNonExpired
				//6.账户没有被锁定  (true 为没有锁定) isAccountNonLocked 主要用于用户是否被冻结
				//7.权限逻辑
		String password = "ginger";
		String encodePassword = passwordEncoder.encode(password);
		logger.info("原密码为:"+password+" ,加密之后的密码为:"+encodePassword);
		return new SocialUser(username,encodePassword,true,true,true,true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER,ROLE_ADMIN"));
	}
}

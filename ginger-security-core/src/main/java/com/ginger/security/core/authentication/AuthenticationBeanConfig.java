/**
 * 
 */
package com.ginger.security.core.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUserDetailsService;
/**
 * @Description: 认证相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置。
 * @author 姜锋
 * @date 2018年10月14日 下午3:59:35 
 * @version V1.0   
 *
 */
@Configuration
public class AuthenticationBeanConfig {
	
	/**
	 * 默认密码处理器
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(PasswordEncoder.class)
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * 默认认证器
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(UserDetailsService.class)
	public UserDetailsService userDetailsService() {
		return new DefaultUserDetailsService();
	}

	/**
	 * 默认认证器
	 * 
	 * @return
	 */
	@Bean
	@ConditionalOnMissingBean(SocialUserDetailsService.class)
	public SocialUserDetailsService socialUserDetailsService() {
		return new DefaultSocialUserDetailsService();
	}
}

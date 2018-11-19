/**
 * 
 */
package com.ginger.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import com.ginger.security.core.authorize.AuthorizeConfigProvider;

/**
 * @Description:Demo授权配置
 * @author 姜锋
 * @date 2018年10月14日 上午11:07:22 
 * @version V1.0   
 *
 */
@Component
public class DemoAuthorizeConfigProvider implements AuthorizeConfigProvider {
	
	
	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		
		//config.anyRequest().access("@rbacService.hasPermission(request, authentication)");
		/*config.antMatchers("/user").hasRole("ADMIN")
		.antMatchers("/demo.html").hasRole("MANAGER")
		.antMatchers(HttpMethod.GET,"/role/*").access("hasRole('ADMIN') and hasIpAddress('192.168.3.105')")
		;*/
		/* (non-Javadoc)
		 * @see com.imooc.security.core.authorize.AuthorizeConfigProvider#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
		 */
		//demo项目授权配置
		 return false;
	}
}

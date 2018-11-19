/**
 * 
 */
package com.ginger.security.browser.authorize;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import com.ginger.security.core.authorize.AuthorizeConfigProvider;

/**
 * @Description: 浏览器环境默认的授权配置，对常见的静态资源，如js,css，图片等不验证身份
 * @author 姜锋
 * @date 2018年10月14日 下午5:25:40 
 * @version V1.0   
 *
 */
public class BrowserAuthorizeConfigProvider implements AuthorizeConfigProvider {
	/* (non-Javadoc)
	 * @see com.imooc.security.core.authorize.AuthorizeConfigProvider#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry)
	 */
	@Override
	public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
		config.antMatchers(HttpMethod.GET, 
			"/**/*.js",
			"/**/*.css",
			"/**/*.jpg",
			"/**/*.png",
			"/**/*.gif").permitAll();
		return false;
	}
}

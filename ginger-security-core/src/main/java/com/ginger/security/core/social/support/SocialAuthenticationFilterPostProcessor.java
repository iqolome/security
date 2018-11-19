/**
 * 
 */
package com.ginger.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @Description: SocialAuthenticationFilter后处理器，用于在不同环境下个性化社交登录的配置
 * @author 姜锋
 * @date 2018年10月6日 下午9:47:20 
 * @version V1.0   
 *
 */
public interface SocialAuthenticationFilterPostProcessor {
	
	void process(SocialAuthenticationFilter socialAuthenticationFilter);
}

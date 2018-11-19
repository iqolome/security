/**
 * 
 */
package com.ginger.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Description: QQ登录配置项
 * @author 姜锋
 * @date 2018年9月24日 下午6:26:31 
 * @version V1.0   
 *
 */
public class QQProperties extends SocialProperties{
	
	 private String providerId = "qq";

	/**
	 * @return providerId
	 */
	public String getProviderId() {
		return providerId;
	}

	/**
	 * @param providerId 要设置的 providerId
	 */
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	 
	 
}

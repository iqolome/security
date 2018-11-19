/**
 * 
 */
package com.ginger.security.core.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @Description: 微信登录配置项
 * @author 姜锋
 * @date 2018年10月4日 下午1:26:32 
 * @version V1.0   
 *
 */
public class WeixinProperties extends SocialProperties {
	/**
	 * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
	 */
	 private String providerId = "weixin";

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

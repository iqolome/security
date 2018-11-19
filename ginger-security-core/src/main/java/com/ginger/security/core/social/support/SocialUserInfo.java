/**
 * 
 */
package com.ginger.security.core.social.support;

/**
 * @Description: 社会化用户信息 
 * @author 姜锋
 * @date 2018年10月3日 下午6:44:19 
 * @version V1.0   
 *
 */
public class SocialUserInfo {
	
	private String providerId;
	private String providerUserId;
	private String nickname;
	private String headimg;
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
	/**
	 * @return providerUserId
	 */
	public String getProviderUserId() {
		return providerUserId;
	}
	/**
	 * @param providerUserId 要设置的 providerUserId
	 */
	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}
	/**
	 * @return nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname 要设置的 nickname
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return headimg
	 */
	public String getHeadimg() {
		return headimg;
	}
	/**
	 * @param headimg 要设置的 headimg
	 */
	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
	
}

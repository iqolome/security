/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 认证服务器注册的第三方应用配置项
 * @author 姜锋
 * @date 2018年10月9日 上午10:49:00 
 * @version V1.0   
 *
 */
public class OAuth2ClientProperties {
	
	private String clientId;
	
	private String clientSecret;
	
	//token有效期设置已秒为单位  例: 7200秒(约俩小时)
	//如果为0 则永不过期
	private int accessTokenValiditySeconds = 7200;
	
	

	/**
	 * @return clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId 要设置的 clientId
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return clientSecret
	 */
	public String getClientSecret() {
		return clientSecret;
	}

	/**
	 * @param clientSecret 要设置的 clientSecret
	 */
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 * @return accessTokenValiditySeconds
	 */
	public int getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	/**
	 * @param accessTokenValiditySeconds 要设置的 accessTokenValiditySeconds
	 */
	public void setAccessTokenValiditySeconds(int accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	
	
}

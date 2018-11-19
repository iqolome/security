/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: OAuth2配置
 * @author 姜锋
 * @date 2018年10月9日 上午10:48:33 
 * @version V1.0   
 *
 */
public class OAuth2Properties {
	
	/**
	 * 使用jwt时为token签名的秘钥
	 */
	String jwtSigningKey = "ginger";
	/**
	 * 客户端配置
	 */
	OAuth2ClientProperties[] clients = {};

	/**
	 * @return clients
	 */
	public OAuth2ClientProperties[] getClients() {
		return clients;
	}

	/**
	 * @param clients 要设置的 clients
	 */
	public void setClients(OAuth2ClientProperties[] clients) {
		this.clients = clients;
	}

	/**
	 * @return jwtSigningKey
	 */
	public String getJwtSigningKey() {
		return jwtSigningKey;
	}

	/**
	 * @param jwtSigningKey 要设置的 jwtSigningKey
	 */
	public void setJwtSigningKey(String jwtSigningKey) {
		this.jwtSigningKey = jwtSigningKey;
	}
	
	
}

/**
 * 
 */
package com.ginger.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: 主安全配置 
 * @author 姜锋
 * @date 2018年4月12日 下午12:20:25 
 * @version V1.0   
 *
 */
@ConfigurationProperties(prefix = "ginger.security")
public class SecurityProperties {

	/**
	 * 浏览器环境配置
	 */
	private BrowserProperties browser = new BrowserProperties();
	/**
	 * 验证码配置
	 */
	private ValidateCodeProperties code = new ValidateCodeProperties();
	/**
	 * 社交登录配置
	 */
	private SocialProperties social = new SocialProperties();
	/**
	 * OAuth2认证服务器配置
	 */
	OAuth2Properties oauth2 = new OAuth2Properties();
	/**
	 * @return browser
	 */
	public BrowserProperties getBrowser() {
		return browser;
	}
	/**
	 * @param browser 要设置的 browser
	 */
	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}
	/**
	 * @return code
	 */
	public ValidateCodeProperties getCode() {
		return code;
	}
	/**
	 * @param code 要设置的 code
	 */
	public void setCode(ValidateCodeProperties code) {
		this.code = code;
	}
	/**
	 * @return social
	 */
	public SocialProperties getSocial() {
		return social;
	}
	/**
	 * @param social 要设置的 social
	 */
	public void setSocial(SocialProperties social) {
		this.social = social;
	}
	/**
	 * @return oauth2
	 */
	public OAuth2Properties getOauth2() {
		return oauth2;
	}
	/**
	 * @param oauth2 要设置的 oauth2
	 */
	public void setOauth2(OAuth2Properties oauth2) {
		this.oauth2 = oauth2;
	}
	
	

	
	
	
}

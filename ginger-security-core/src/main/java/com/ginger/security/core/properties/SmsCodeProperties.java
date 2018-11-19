/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 短信验证码配置
 * @author 姜锋
 * @date 2018年4月13日 上午11:10:13 
 * @version V1.0   
 *
 */
public class SmsCodeProperties extends SMSConfigProperties{
	
	/**
	 * 验证码长度
	 */
	private int length = 6;
	/**
	 * 过期时间
	 */
	private int expireIn = 60;
	/**
	 * 要拦截的url，多个url用逗号隔开，ant pattern
	 */
	private String url;

	public int getLength() {
		return length;
	}
	/**
	 * @param length 要设置的 length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @return expireIn
	 */
	public int getExpireIn() {
		return expireIn;
	}
	/**
	 * @param expireIn 要设置的 expireIn
	 */
	public void setExpireIn(int expireIn) {
		this.expireIn = expireIn;
	}
	/**
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url 要设置的 url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}

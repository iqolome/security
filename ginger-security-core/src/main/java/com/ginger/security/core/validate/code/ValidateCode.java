/**
 * 
 */
package com.ginger.security.core.validate.code;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 验证码信息封装类 
 * @author 姜锋
 * @date 2018年4月12日 下午11:08:11 
 * @version V1.0   
 *
 */
public class ValidateCode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3097299968878344461L;

	//随机数
	private String code;
	
	private LocalDateTime expireTime;
	
	private String url;
	
	public ValidateCode(String code, int expireIn) {
		this.code = code;
		this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
	}

	/**
	 * @param image
	 * @param code
	 * @param expireTime
	 */
	public ValidateCode(String code, LocalDateTime expireTime) {
		this.code = code;
		this.expireTime = expireTime;
	}

	
	public boolean isExpried() {
		return LocalDateTime.now().isAfter(expireTime);
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code 要设置的 code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return expireTime
	 */
	public LocalDateTime getExpireTime() {
		return expireTime;
	}

	/**
	 * @param expireTime 要设置的 expireTime
	 */
	public void setExpireTime(LocalDateTime expireTime) {
		this.expireTime = expireTime;
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

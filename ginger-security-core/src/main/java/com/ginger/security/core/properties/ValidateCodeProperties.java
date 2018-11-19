/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 验证码配置 
 * @author 姜锋
 * @date 2018年4月13日 上午11:12:48 
 * @version V1.0   
 *
 */
public class ValidateCodeProperties {

	/**
	 * 图片验证码配置
	 */
	private ImageCodeProperties image = new ImageCodeProperties();
	/**
	 * 短信验证码配置
	 */
	private SmsCodeProperties sms = new SmsCodeProperties();

	/**
	 * @return image
	 */
	public ImageCodeProperties getImage() {
		return image;
	}

	/**
	 * @param image 要设置的 image
	 */
	public void setImage(ImageCodeProperties image) {
		this.image = image;
	}

	/**
	 * @return sms
	 */
	public SmsCodeProperties getSms() {
		return sms;
	}

	/**
	 * @param sms 要设置的 sms
	 */
	public void setSms(SmsCodeProperties sms) {
		this.sms = sms;
	}
	
	
}

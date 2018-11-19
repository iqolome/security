/**
 * 
 */
package com.ginger.security.core.validate.code.sms;

/**
 * @Description: 短信验证码接口
 * @author 姜锋
 * @date 2018年4月14日 上午10:44:41 
 * @version V1.0   
 *
 */
public interface SmsCodeSender {
	
	void send(String tpl_id, String mobile, String code);
}

/**
 * 
 */
package com.ginger.security.core.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.validate.code.ValidateCode;
import com.ginger.security.core.validate.code.ValidateCodeGenerator;

/**
 * @Description: 短信验证码生成器
 * @author 姜锋
 * @date 2018年4月14日 上午11:02:15 
 * @version V1.0   
 *
 */
@Component("smsValidateCodeGenerator")
public class SmsCodeGenerator implements ValidateCodeGenerator{
	
	@Autowired
	private SecurityProperties securityProperties;
	
	/**
	 * @Description: 生成短信验证码
	 * @author 姜锋
	 * @date 2018年4月12日 下午11:16:26
	 * @param @param request
	 * @param @return
	 * @return ImageCode
	 * @throws
	 */
	@Override
	public ValidateCode generate(ServletWebRequest request) {
		
		String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
		
		return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());
	}


	/**
	 * @return securityProperties
	 */
	public SecurityProperties getSecurityProperties() {
		return securityProperties;
	}

	/**
	 * @param securityProperties 要设置的 securityProperties
	 */
	public void setSecurityProperties(SecurityProperties securityProperties) {
		this.securityProperties = securityProperties;
	}
	
}

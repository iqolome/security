/**
 * 
 */
package com.ginger.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.validate.code.image.ImageCodeGenerator;
import com.ginger.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.ginger.security.core.validate.code.sms.SmsCodeSender;

/**
 * @Description:  验证码相关的扩展点配置。配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全
 * 模块默认的配置
 * @author 姜锋
 * @date 2018年4月13日 下午11:46:10 
 * @version V1.0   
 *
 */
@Configuration
public class ValidateCodeBeanConfig {
	
	@Autowired
	private SecurityProperties securityProperties;
	
	/**
	 * 
	 * @Description: 已注解的方式(如果项目不存在指定名称的Bean则使用此Bean)
	 * @author 姜锋
	 * @date 2018年9月23日 下午4:40:56
	 * @param @return
	 * @return ValidateCodeGenerator
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
	public ValidateCodeGenerator imageCodeGenerator() {
		ImageCodeGenerator codeGenerator = new ImageCodeGenerator();
		codeGenerator.setSecurityProperties(securityProperties);
		return codeGenerator;
	}
	/**
	 * 
	 * @Description: 类注入的方式(如果项目不存在指定名称的Bean则使用此Bean)
	 * @author 姜锋
	 * @date 2018年9月23日 下午4:42:21
	 * @param @return
	 * @return SmsCodeSender
	 * @throws
	 */
	@Bean
	@ConditionalOnMissingBean(SmsCodeSender.class)
	public SmsCodeSender smsCodeSender() {
		return new DefaultSmsCodeSender();
	}
	
}

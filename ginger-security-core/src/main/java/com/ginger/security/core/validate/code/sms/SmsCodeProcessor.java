/**
 * 
 */
package com.ginger.security.core.validate.code.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import com.ginger.security.core.properties.SecurityConstants;
import com.ginger.security.core.validate.code.ValidateCode;
import com.ginger.security.core.validate.code.impl.AbstractValidateCodeProcessor;

/**
 * @Description: 短信验证码处理器
 * @author 姜锋
 * @date 2018年4月14日 下午12:52:16 
 * @version V1.0   
 *
 */
@Component("smsValidateCodeProcessor")
public class SmsCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode>{
	/**
	 * 短信验证码发送器
	 */
	@Autowired
	private SmsCodeSender smsCodeSender;
	
	@Override
	protected void send(ServletWebRequest request, ValidateCode validateCode) throws Exception {
		String mobileParamName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
		String templateIdParamName = SecurityConstants.DEFAULT_PARAMETER_NAME_TEMPLATE_ID;

		String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), mobileParamName);
		String tpl_id = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), templateIdParamName);
		smsCodeSender.send(tpl_id, mobile, validateCode.getCode());
	}

}

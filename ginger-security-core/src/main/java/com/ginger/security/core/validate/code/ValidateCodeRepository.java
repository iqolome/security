/**
 * 
 */
package com.ginger.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 校验码存取器
 * @author 姜锋
 * @date 2018年10月6日 下午5:51:51 
 * @version V1.0   
 *
 */
public interface ValidateCodeRepository {
	/**
	 * 保存验证码
	 * @param request
	 * @param code
	 * @param validateCodeType
	 */
	void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType);
	/**
	 * 获取验证码
	 * @param request
	 * @param validateCodeType
	 * @return
	 */
	ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType);
	/**
	 * 移除验证码
	 * @param request
	 * @param codeType
	 */
	void remove(ServletWebRequest request, ValidateCodeType codeType);
}

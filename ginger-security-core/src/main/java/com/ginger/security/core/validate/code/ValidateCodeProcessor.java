/**
 * 
 */
package com.ginger.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 验证码接口
 * @author 姜锋
 * @date 2018年4月14日 下午12:38:55 
 * @version V1.0   
 *
 */
public interface ValidateCodeProcessor {
	

	/**
	 * 创建校验码
	 * 
	 * @param request
	 * @throws Exception
	 */
	void create(ServletWebRequest request) throws Exception;

	/**
	 * 校验验证码
	 * 
	 * @param servletWebRequest
	 * @throws Exception
	 */
	void validate(ServletWebRequest servletWebRequest);
}

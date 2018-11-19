/**
 * 
 */
package com.ginger.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @Description: 编写图形验证码错误异常
 * @author 姜锋
 * @date 2018年4月12日 下午11:47:31 
 * @version V1.0   
 *
 */
public class ValidateCodeException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -744387664913382154L;

	/**
	 * @param msg
	 */
	public ValidateCodeException(String msg) {
		super(msg);
	}
	
	
}

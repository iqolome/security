/**
 * 
 */
package com.ginger.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: 校验码生成器
 * @author 姜锋
 * @date 2018年4月13日 下午11:37:56
 * @version V1.0
 */
public interface ValidateCodeGenerator {
	ValidateCode generate(ServletWebRequest request);
}

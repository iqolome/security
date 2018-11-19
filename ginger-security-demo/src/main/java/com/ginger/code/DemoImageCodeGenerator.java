/**
 * 
 */
package com.ginger.code;

import org.springframework.web.context.request.ServletWebRequest;

import com.ginger.security.core.validate.code.ValidateCodeGenerator;
import com.ginger.security.core.validate.code.image.ImageCode;

/**
 * @Description: 可替换的图形验证码逻辑 
 * @author 姜锋
 * @date 2018年4月13日 下午11:57:11 
 * @version V1.0   
 *
 */
//可替换原有图形验证码生成逻辑
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator{
	
	@Override
	public ImageCode generate(ServletWebRequest request) {
		
		
		System.out.println("更高级的图形验证码生成代码");
		return null;
	}
}

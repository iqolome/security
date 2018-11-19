/**
 * 
 */
package com.ginger.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ginger.service.CustomService;

/**
 * @Description: 自定义验证规则
 * @author 姜锋
 * @date 2018年4月10日 上午11:16:51 
 * @version V1.0   
 *
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {
	
	
	@Autowired
	private CustomService customService; 
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	/* （非 Javadoc）
	 * @see javax.validation.ConstraintValidator#initialize(java.lang.annotation.Annotation)
	 */
	@Override
	public void initialize(MyConstraint constraintAnnotation) {
		logger.info("我的验证器初始化");
	}

	/* （非 Javadoc）
	 * @see javax.validation.ConstraintValidator#isValid(java.lang.Object, javax.validation.ConstraintValidatorContext)
	 */
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		
		logger.info("我的验证值"+value);
		
		return customService.userAlreadyExisted("tom");
				
	}
}

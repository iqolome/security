/**
 * 
 */
package com.ginger.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @Description: 自定义注解验证
 * @author 姜锋
 * @date 2018年4月10日 上午11:12:07 
 * @version V1.0   
 *
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {
	String message() default "该帐号已存在";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}

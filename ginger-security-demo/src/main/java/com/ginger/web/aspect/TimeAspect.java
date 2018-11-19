/** 
 * 切片描述:
 *  可以拿到真正处理请求的方法信息
 *  可以拿到方法处理时的参数值
 *  拿不到到原始http请求和响应信息
*/
package com.ginger.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: Time切面
 * @author 姜锋
 * @date 2018年4月11日 下午7:07:42 
 * @version V1.0   
 *
 */
@Aspect
@Component
public class TimeAspect {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Around("execution(* com.ginger.web.controller.UserController.*(..))")
	public Object handleControllerMethod (ProceedingJoinPoint pjp) throws Throwable {
		
		logger.info("time aspect start");
		Long start = new Date().getTime();
	
		Object [] args =  pjp.getArgs();
		for (Object arg : args) {
			logger.info("arg is "+arg);
		}
		Object object = pjp.proceed();
		logger.info("time aspect  耗时:" +(new Date().getTime()-start));
		logger.info("time aspect 结束");
		return object;
		
	}
}

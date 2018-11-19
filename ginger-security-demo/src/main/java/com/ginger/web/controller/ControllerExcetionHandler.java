/**
 * 
 */
package com.ginger.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ginger.excetion.UserNotExistExcetion;

/**
 * @Description: 控制器错误处理
 * @author 姜锋
 * @date 2018年4月11日 上午10:47:19 
 * @version V1.0   
 *
 */
@ControllerAdvice
public class ControllerExcetionHandler {
	
	@ExceptionHandler(UserNotExistExcetion.class)
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> handleUserNotExistExcetion(UserNotExistExcetion ex){
		Map<String, Object> result = new HashMap<>();
		
		result.put("id", ex.getId());
		result.put("message", ex.getMessage());
		return result;
	}
	
	
	
}

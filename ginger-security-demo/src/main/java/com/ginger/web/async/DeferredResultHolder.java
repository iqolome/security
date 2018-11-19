/**
 * 
 */
package com.ginger.web.async;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description: 传递对象
 * @author 姜锋
 * @date 2018年4月11日 下午8:54:37 
 * @version V1.0   
 *
 */
@Component
public class DeferredResultHolder {
	
	private Map<String , DeferredResult<String>> map = new HashMap<String , DeferredResult<String>>();

	public Map<String, DeferredResult<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, DeferredResult<String>> map) {
		this.map = map;
	}
}

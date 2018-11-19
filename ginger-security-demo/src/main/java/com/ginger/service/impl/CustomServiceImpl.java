/**
 * 
 */
package com.ginger.service.impl;

import org.springframework.stereotype.Service;

import com.ginger.service.CustomService;

/**
 * @Description: 用户
 * @author 姜锋
 * @date 2018年4月10日 下午3:37:24 
 * @version V1.0   
 *
 */
@Service
public class CustomServiceImpl implements CustomService {
	
	@Override
	public boolean userAlreadyExisted(String username) {
		return false;
	}
}

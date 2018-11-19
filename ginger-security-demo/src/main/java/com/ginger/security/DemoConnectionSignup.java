/**
 * 
 */
package com.ginger.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * @Description: 社交用户登录自动注册
 * @author 姜锋
 * @date 2018年10月4日 上午11:59:11 
 * @version V1.0   
 *
 */
//@Component
public class DemoConnectionSignup implements ConnectionSignUp {

	@Override
	public String execute(Connection<?> connection) {
		//根据社交用户信息默认创建用户并返回用户唯一标识
		return connection.getDisplayName();
	}
}

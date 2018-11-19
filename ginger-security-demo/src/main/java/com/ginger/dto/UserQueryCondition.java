/**
 * 
 */
package com.ginger.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 用户查询类
 * @author 姜锋
 * @date 2018年4月10日 上午8:46:42 
 * @version V1.0   
 *
 */
public class UserQueryCondition {
	
	@ApiModelProperty(value = "用户名")
	private String username;
	@ApiModelProperty(value = "年龄起")
	private int age;
	@ApiModelProperty(value = "年龄止")
	private int ageTo;
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age 要设置的 age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return ageTo
	 */
	public int getAgeTo() {
		return ageTo;
	}
	/**
	 * @param ageTo 要设置的 ageTo
	 */
	public void setAgeTo(int ageTo) {
		this.ageTo = ageTo;
	}
	
	
}

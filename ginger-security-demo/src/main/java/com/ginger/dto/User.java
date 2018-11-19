/**
 * 
 */
package com.ginger.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.ginger.validator.MyConstraint;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 用户类
 * @author 姜锋
 * @date 2018年4月10日 上午8:32:55 
 * @version V1.0   
 *
 */
public class User {
	
	public interface UserSimpleView{};
	public interface UserDetailView extends UserSimpleView {};
	
	@ApiModelProperty(value = "用户编号")
	private String id;
	
	@MyConstraint
	@ApiModelProperty(value = "用户名")
	private String username;
	
	@NotBlank(message = "密码不能为空")
	@ApiModelProperty(value = "密码")
	private String password;
	
	@Past(message = "日期非法")
	@ApiModelProperty(value = "出生日期")
	private Date birthday;
	/**
	 * @return username
	 */
	@JsonView(UserSimpleView.class)
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
	 * @return password
	 */
	@JsonView(UserDetailView.class)
	public String getPassword() {
		return password;
	}
	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return id
	 */
	@JsonView(UserSimpleView.class)
	public String getId() {
		return id;
	}
	/**
	 * @param id 要设置的 id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return birthday
	 */
	@JsonView(UserSimpleView.class)
	public Date getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday 要设置的 birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}

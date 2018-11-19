/**
 * 
 */
package com.ginger.security.rbac.dto;

/**
 * 
 * @Description: 用户信息
 * @author 姜锋
 * @date 2018年10月14日 下午5:50:25 
 * @version V1.0   
 *
 */
public class RoleInfo {
	
	private Long id;
	
	private String name;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}

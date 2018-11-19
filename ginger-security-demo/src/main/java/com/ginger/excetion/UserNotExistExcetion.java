/**
 * 
 */
package com.ginger.excetion;

/**
 * @Description: 用户不存在异常
 * @author 姜锋
 * @date 2018年4月11日 上午10:43:05
 * @version V1.0
 */
public class UserNotExistExcetion extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5796777332075351485L;

	private String id;
	public UserNotExistExcetion(String id) {
		super("用户不存在");
		this.id = id;
	}
	/**
	 * @return id
	 */
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
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

/**
 * 
 */
package com.ginger.security.core.support;

/**
 * @Description: 处理返回类型信息
 * @author 姜锋
 * @date 2018年4月12日 下午12:12:47 
 * @version V1.0   
 *
 */
public class SimpleResponse {
	
	private Object content;
	
	

	/**
	 * @param content
	 */
	public SimpleResponse(Object content) {
		super();
		this.content = content;
	}

	/**
	 * @return content
	 */
	public Object getContent() {
		return content;
	}

	/**
	 * @param content 要设置的 content
	 */
	public void setContent(Object content) {
		this.content = content;
	}
	
	
}

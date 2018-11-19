/**
 * 
 */
package com.ginger.security.rbac.web.controller.support;

/**
 * 
 * @Description: SimpleResponse
 * @author 姜锋
 * @date 2018年10月14日 下午6:01:16 
 * @version V1.0   
 *
 */
public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}

/**
 * 
 */
package com.ginger.security.core.validate.code.sms;

import java.io.Serializable;

/**
 * @Description: 短信信息
 * @author 姜锋
 * @date 2018年9月16日 下午7:54:24 
 * @version V1.0   
 *
 */
public class SMSObject implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4320192795565015078L;

	private String return_code;
	
	private String order_id;

	/**
	 * @return return_code
	 */
	public String getReturn_code() {
		return return_code;
	}

	/**
	 * @param return_code 要设置的 return_code
	 */
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	/**
	 * @return order_id
	 */
	public String getOrder_id() {
		return order_id;
	}

	/**
	 * @param order_id 要设置的 order_id
	 */
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	/**
	 * @return serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "SMSObject [return_code=" + return_code + ", order_id=" + order_id + "]";
	}

}

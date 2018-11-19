/**
 * 
 */
package com.ginger.security.app.exception;

/**
 * @Description: AppSecre异常处理
 * @author 姜锋
 * @date 2018年10月7日 上午7:30:51 
 * @version V1.0   
 *
 */
public class AppSecretException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7285750817857134754L;

	/**
	 * 
	 */

	public AppSecretException(String msg){
		super(msg);
	}
}

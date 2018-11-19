/**
 * 
 */
package com.ginger.service;

/**
 * @Description: 用户
 * @author 姜锋
 * @date 2018年4月10日 下午3:22:04 
 * @version V1.0   
 *
 */
public interface CustomService {
	
	/**
	 * 
	 * @Description: 检查帐号是否存在
	 * @author 姜锋
	 * @date 2018年4月10日 下午3:25:02
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public boolean userAlreadyExisted(String username);
}

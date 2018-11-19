/**
 * 
 */
package com.ginger.security.core.social.qq.connection;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import com.ginger.security.core.social.qq.api.QQ;

/**
 * @Description: QQ连接工厂
 * @author 姜锋
 * @date 2018年9月24日 下午4:50:36 
 * @version V1.0   
 *
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

	/**
	 * @param providerId
	 * @param serviceProvider
	 * @param apiAdapter
	 */
	public QQConnectionFactory(String providerId, String appId, String appSecret) {
		super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
	}
	
	
}

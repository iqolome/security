/**
 * 
 */
package com.ginger.security.core.social.qq.connection;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import com.ginger.security.core.social.qq.api.QQ;
import com.ginger.security.core.social.qq.api.QQImpl;

/**
 * @Description: QQ服务提供商
 * @author 姜锋
 * @date 2018年9月17日 下午5:15:51 
 * @version V1.0   
 *
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ>{
	
	private String appId;

	private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
	
	private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";
	
	
	/**
	 * @param oauth2Operations
	 */
	public QQServiceProvider(String appId, String appSecret) {
		super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
		this.appId = appId;
	}

	@Override
	public QQ getApi(String accessToken) {
		return new QQImpl(accessToken, appId);
	}
}

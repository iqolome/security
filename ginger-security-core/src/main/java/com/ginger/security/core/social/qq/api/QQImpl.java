/**
 * 
 */
package com.ginger.security.core.social.qq.api;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: QQAPI
 * @author 姜锋
 * @date 2018年9月17日 下午4:19:06 
 * @version V1.0   
 *
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ {
	private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";
	private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?oauth_consumer_key=%s&openid=%s";
	private String appId;
	private String openId;
	private ObjectMapper objectMapper= new ObjectMapper();
	@Autowired
	private Logger loggger = LoggerFactory.getLogger(getClass());

	/**
	 * 
	 */
	public QQImpl(String accessToken, String appId) {
		
		super(accessToken,TokenStrategy.ACCESS_TOKEN_PARAMETER);
		this.appId = appId;
		String url = String.format(URL_GET_OPENID, accessToken);
		String result = getRestTemplate().getForObject(url, String.class);
		loggger.debug("测试构造器返回的值: " + result);
		this.openId = StringUtils.substringBetween(result, "\"openid\":\"", "\"}");
	}
	
	@Override
	public QQUserInfo getUserInfo() {
		String url = String.format(URL_GET_USERINFO, appId, openId);
		String result = getRestTemplate().getForObject(url, String.class);
		loggger.debug("测试接收的返回: " + result);
		QQUserInfo userInfo = null;
		try {
			userInfo =  objectMapper.readValue(result, QQUserInfo.class);
			userInfo.setOpenId(openId);
			return userInfo;
		} catch (Exception e) {
			
			throw new RuntimeException("获取用户信息失败",e);
		} 
	}
	
	
	
	
}

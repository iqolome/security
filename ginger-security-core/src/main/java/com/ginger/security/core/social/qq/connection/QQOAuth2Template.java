/**
 * 
 */
package com.ginger.security.core.social.qq.connection;

import java.nio.charset.Charset;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Description: QQOAuth2模版
 * @author 姜锋
 * @date 2018年9月30日 上午10:55:50 
 * @version V1.0   
 *
 */
public class QQOAuth2Template extends OAuth2Template {
	
	@Autowired
	private Logger loggger = LoggerFactory.getLogger(getClass());
	/**
	 * @param clientId
	 * @param clientSecret
	 * @param authorizeUrl
	 * @param authenticateUrl
	 * @param accessTokenUrl
	 */
	public  QQOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
		setUseParametersForClientAuthentication(true);
	}
	
	@Override
	protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
		String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);
		loggger.debug("获取Access Token的响应: "+responseStr);
		String[] items = StringUtils.splitByWholeSeparatorPreserveAllTokens(responseStr, "&");
		String accessToken = StringUtils.substringAfterLast(items[0], "=");
		Long expiresIn =new Long(StringUtils.substringAfterLast(items[1], "="));
		String refreshToken = StringUtils.substringAfterLast(items[2], "=");
		return new AccessGrant(accessToken, null, refreshToken, expiresIn);
		
	}
	
	@Override
	protected RestTemplate createRestTemplate() {

		RestTemplate restTemplate = super.createRestTemplate();
		restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
		
		return restTemplate;
	}
}

/**
 * 
 */
package com.ginger.security.core.social;

import org.springframework.social.connect.Connection;

import com.ginger.security.core.social.support.SocialUserInfo;

/**
 * @Description: 根据Connection信息构建SocialUserInfo
 * @author 姜锋
 * @date 2018年10月14日 下午2:29:02 
 * @version V1.0   
 *
 */
public abstract class SocialController {
	
	/**
	 * 根据Connection信息构建SocialUserInfo
	 * @param connection
	 * @return
	 */
	protected SocialUserInfo buildSocialUserInfo(Connection<?> connection) {
		SocialUserInfo userInfo = new SocialUserInfo();
		userInfo.setProviderId(connection.getKey().getProviderId());
		userInfo.setProviderUserId(connection.getKey().getProviderUserId());
		userInfo.setNickname(connection.getDisplayName());
		userInfo.setHeadimg(connection.getImageUrl());
		return userInfo;
	}
}

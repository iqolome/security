/**
 * 
 */
package com.ginger.security.core.social.qq.connection;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.ginger.security.core.social.qq.api.QQ;
import com.ginger.security.core.social.qq.api.QQUserInfo;

/**
 * @Description: QQ适配器
 * @author 姜锋
 * @date 2018年9月24日 上午11:31:49
 * @version V1.0
 */
public class QQAdapter implements ApiAdapter<QQ> {
	
	@Override
	public boolean test(QQ api) {
		// TODO 测试QQ服务正常
		return true;
	}
	@Override
	public void setConnectionValues(QQ api, ConnectionValues values) {
QQUserInfo userInfo = api.getUserInfo();
		
		values.setDisplayName(userInfo.getNickname());
		values.setImageUrl(userInfo.getFigureurl_qq_1());
		//用戶的主页
		values.setProfileUrl(null);
		values.setProviderUserId(userInfo.getOpenId());
	}


	@Override
	public UserProfile fetchUserProfile(QQ api) {
		// TODO 提出用户信息
		return null;
	}


	@Override
	public void updateStatus(QQ api, String message) {
		// do noting
	}
}

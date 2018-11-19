/**
 * 
 */
package com.ginger.security.core.social.weixin.connection;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import com.ginger.security.core.social.weixin.api.Weixin;
import com.ginger.security.core.social.weixin.api.WeixinUserInfo;

/**
 * @Description: 微信 api适配器，将微信 api的数据模型转为spring social的标准模型。
 * @author 姜锋
 * @date 2018年10月4日 下午1:58:55 
 * @version V1.0   
 *
 */
public class WeixinAdapter implements ApiAdapter<Weixin> {
private String openId;
	
	public WeixinAdapter() {}
	
	public WeixinAdapter(String openId){
		this.openId = openId;
	}

	/**
	 * @param api
	 * @return
	 */
	@Override
	public boolean test(Weixin api) {
		return true;
	}

	/**
	 * @param api
	 * @param values
	 */
	@Override
	public void setConnectionValues(Weixin api, ConnectionValues values) {
		WeixinUserInfo profile = api.getUserInfo(openId);
		values.setProviderUserId(profile.getOpenid());
		values.setDisplayName(profile.getNickname());
		values.setImageUrl(profile.getHeadimgurl());
	}

	/**
	 * @param api
	 * @return
	 */
	@Override
	public UserProfile fetchUserProfile(Weixin api) {
		return null;
	}

	/**
	 * @param api
	 * @param message
	 */
	@Override
	public void updateStatus(Weixin api, String message) {
		//do nothing
	}
}

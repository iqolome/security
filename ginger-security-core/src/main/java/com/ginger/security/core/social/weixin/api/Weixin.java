/**
 * 
 */
package com.ginger.security.core.social.weixin.api;

/**
 * @Description: 微信API调用
 * @author 姜锋
 * @date 2018年10月4日 下午1:35:57 
 * @version V1.0   
 *
 */
public interface Weixin {
	
	WeixinUserInfo getUserInfo(String openId);
}

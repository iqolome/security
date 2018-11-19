/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 系统配置项
 * @author 姜锋
 * @date 2018年9月23日 下午8:03:36 
 * @version V1.0   
 *
 */
public interface SecurityConstants {
	
	/**
	 * 默认的处理验证码的url前缀
	 */
	 String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";
	/**
	 * 当请求需要身份认证时，默认跳转的url
	 * 
	 * @see SecurityController
	 */
	 String DEFAULT_UNAUTHENTICATION_URL = "/authentication/require";
	/**
	 * 默认的用户名密码登录请求处理url
	 */
	 String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";
	/**
	 * 默认的手机验证码登录请求处理url
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";
	/**
	 * 默认的OPENID登录请求处理url
	 */
	String DEFAULT_SIGN_IN_PROCESSING_URL_OPENID = "/authentication/openid";
	/**
	 * 社交登录，如果需要用户注册，跳转的页面
	 */
	String DEFAULT_SIGN_UP_PAGE_URL = "/ginger-signUp.html";
	
	/**
	 * 默认登录页面
	 * 
	 * @see SecurityController
	 */
	String DEFAULT_SIGN_IN_PAGE_URL = "/ginger-signIn.html";
	/**
	 * 
	 */
	String DEFAULT_SIGN_OUT_PROCESSING_URL = "/authentication/openid";
	/**
	 * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";
	/**
	 * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";
	/**
	 * 发送短信验证码 或 验证短信验证码时，传递模版的参数的名称
	 */
	String DEFAULT_PARAMETER_NAME_TEMPLATE_ID = "tpl_id";

	/**
	 * openid参数名
	 */
	String DEFAULT_PARAMETER_NAME_OPENID = "openId";
	/**
	 * providerId参数名
	 */
	String DEFAULT_PARAMETER_NAME_PROVIDERID = "providerId";
	/**
	 * session失效默认的跳转地址
	 */
	String DEFAULT_SESSION_INVALID_URL = "/ginger-session-invalid.html";
	/**
	 * 获取第三方用户信息的url
	 */
	String DEFAULT_SOCIAL_USER_INFO_URL = "/social/user";
}

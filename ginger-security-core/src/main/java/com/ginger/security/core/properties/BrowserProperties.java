/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 浏览器配置 
 * @author 姜锋
 * @date 2018年4月12日 下午12:23:18 
 * @version V1.0   
 *
 */
public class BrowserProperties {
	
	/**
	 * session管理配置项
	 */
	private SessionProperties session = new SessionProperties();
	
	private String signInPage = SecurityConstants.DEFAULT_SIGN_IN_PAGE_URL;
	/**
	 * 社交登录，如果需要用户注册，跳转的页面
	 */
	private String signUpUrl = SecurityConstants.DEFAULT_SIGN_UP_PAGE_URL;
	/**
	 * 退出成功时跳转的url，如果配置了，则跳到指定的url，如果没配置，则返回json数据。
	 */
	private String signOutUrl;
	/**
	 * 登录响应的方式，默认是json
	 */
	
	private LoginResponseType  loginResponseType  = LoginResponseType.JSON;
	
	/**
	 * '记住我'功能的有效时间，默认1小时
	 */
	private int rememberMeSeconds = 3600;
	/**
	 * 登录成功后跳转的地址，如果设置了此属性，则登录成功后总是会跳到这个地址上。
	 * 
	 * 只在signInResponseType为REDIRECT时生效
	 */
	private String singInSuccessUrl;
	/**
	 * @return session
	 */
	public SessionProperties getSession() {
		return session;
	}
	/**
	 * @param session 要设置的 session
	 */
	public void setSession(SessionProperties session) {
		this.session = session;
	}
	/**
	 * @return signInPage
	 */
	public String getSignInPage() {
		return signInPage;
	}
	/**
	 * @param signInPage 要设置的 signInPage
	 */
	public void setSignInPage(String signInPage) {
		this.signInPage = signInPage;
	}
	/**
	 * @return signUpUrl
	 */
	public String getSignUpUrl() {
		return signUpUrl;
	}
	/**
	 * @param signUpUrl 要设置的 signUpUrl
	 */
	public void setSignUpUrl(String signUpUrl) {
		this.signUpUrl = signUpUrl;
	}
	/**
	 * @return signOutUrl
	 */
	public String getSignOutUrl() {
		return signOutUrl;
	}
	/**
	 * @param signOutUrl 要设置的 signOutUrl
	 */
	public void setSignOutUrl(String signOutUrl) {
		this.signOutUrl = signOutUrl;
	}
	/**
	 * @return loginResponseType
	 */
	public LoginResponseType getLoginResponseType() {
		return loginResponseType;
	}
	/**
	 * @param loginResponseType 要设置的 loginResponseType
	 */
	public void setLoginResponseType(LoginResponseType loginResponseType) {
		this.loginResponseType = loginResponseType;
	}
	/**
	 * @return rememberMeSeconds
	 */
	public int getRememberMeSeconds() {
		return rememberMeSeconds;
	}
	/**
	 * @param rememberMeSeconds 要设置的 rememberMeSeconds
	 */
	public void setRememberMeSeconds(int rememberMeSeconds) {
		this.rememberMeSeconds = rememberMeSeconds;
	}
	/**
	 * @return singInSuccessUrl
	 */
	public String getSingInSuccessUrl() {
		return singInSuccessUrl;
	}
	/**
	 * @param singInSuccessUrl 要设置的 singInSuccessUrl
	 */
	public void setSingInSuccessUrl(String singInSuccessUrl) {
		this.singInSuccessUrl = singInSuccessUrl;
	}

	
}

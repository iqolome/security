/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description:社会化登录服务配置
 * @author 姜锋
 * @date 2018年9月24日 下午6:33:23 
 * @version V1.0   
 *
 */
public class SocialProperties {
	/**
	 * 社交登录功能拦截的url
	 */
	String filterProcessesUrl = "/auth";
	QQProperties qq = new QQProperties();
	WeixinProperties weixin = new WeixinProperties();

	/**
	 * @return qq
	 */
	public QQProperties getQq() {
		return qq;
	}

	/**
	 * @param qq 要设置的 qq
	 */
	public void setQq(QQProperties qq) {
		this.qq = qq;
	}

	/**
	 * @return filterProcessesUrl
	 */
	public String getFilterProcessesUrl() {
		return filterProcessesUrl;
	}

	/**
	 * @param filterProcessesUrl 要设置的 filterProcessesUrl
	 */
	public void setFilterProcessesUrl(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

	/**
	 * @return weixin
	 */
	public WeixinProperties getWeixin() {
		return weixin;
	}

	/**
	 * @param weixin 要设置的 weixin
	 */
	public void setWeixin(WeixinProperties weixin) {
		this.weixin = weixin;
	}

	/**
	 * @return weixin
	 */
	
	
	
}

/**
 * 
 */
package com.ginger.security.core.social.weixin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.web.servlet.View;

import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.properties.WeixinProperties;
import com.ginger.security.core.social.view.GingerConnectView;
import com.ginger.security.core.social.weixin.connection.WeixinConnectionFactory;

/**
 * @Description: 微信登录配置
 * @author 姜锋
 * @date 2018年10月4日 下午2:56:15 
 * @version V1.0   
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "ginger.security.social.weixin", name = "app-id")
public class WeixinAutoConfiguration extends SocialAutoConfigurerAdapter{
	
	@Autowired
	private SecurityProperties securityProperties;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter
	 * #createConnectionFactory()
	 */
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
		WeixinProperties weixinConfig = securityProperties.getSocial().getWeixin();
		return new WeixinConnectionFactory(weixinConfig.getProviderId(), weixinConfig.getAppId(),
				weixinConfig.getAppSecret());
	}
	/**
	 * 
	 * @Description: 跳转至绑定或解绑视图
	 * @author 姜锋
	 * @date 2018年10月4日 下午5:09:55
	 * @param @return
	 * @return View
	 * @throws
	 */
	@Bean({"connect/weixinConnect", "connect/weixinConnected"})
	@ConditionalOnMissingBean(name = "weixinConnectedView")
	public View weixinConnectedView() {
		return new GingerConnectView();
	}
	
	
}

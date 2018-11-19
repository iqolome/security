/**
 * 
 */
package com.ginger.security.core.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.social.connect.ConnectionFactory;

import com.ginger.security.core.properties.QQProperties;
import com.ginger.security.core.properties.SecurityProperties;
import com.ginger.security.core.social.qq.connection.QQConnectionFactory;

/**
 * @Description: QQ自动配置
 * @author 姜锋
 * @date 2018年9月24日 下午6:36:48 
 * @version V1.0   
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "ginger.security.social.qq", name="app-id")
@Order(2)
public class QQAutoConfig extends SocialAutoConfigurerAdapter{
	
	@Autowired
	private SecurityProperties securityProperties;
	
	@Override
	protected ConnectionFactory<?> createConnectionFactory() {

		QQProperties qqConfig =  securityProperties.getSocial().getQq();
		return new QQConnectionFactory(
				qqConfig.getProviderId(),
				qqConfig.getAppId(),
				qqConfig.getAppSecret()
			);
	}
}

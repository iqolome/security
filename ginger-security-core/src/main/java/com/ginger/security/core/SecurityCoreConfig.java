/**
 * 
 */
package com.ginger.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.ginger.security.core.properties.SecurityProperties;

/**
 * @Description: 安全核心配置
 * @author 姜锋
 * @date 2018年4月12日 下午12:28:11 
 * @version V1.0   
 *
 */
@ Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {
	
}

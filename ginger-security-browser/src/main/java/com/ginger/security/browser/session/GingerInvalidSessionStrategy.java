/**
 * 
 */
package com.ginger.security.browser.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

import com.ginger.security.core.properties.SecurityProperties;

/**
 * @Description: 默认的session失效处理策略
 * @author 姜锋
 * @date 2018年10月4日 下午6:38:16 
 * @version V1.0   
 *
 */
public class GingerInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

	public GingerInvalidSessionStrategy(SecurityProperties securityProperties) {
		super(securityProperties);
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		onSessionInvalid(request, response);
	}
}

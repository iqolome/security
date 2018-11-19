/** 
 * 拦截器描述:
 * 可以拿到原始http请求和响应信息
 *  可以拿到真正处理请求的方法信息
 *  拿不到方法处理时的参数值
*/
package com.ginger.web.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description: Time拦截器
 * @author 姜锋
 * @date 2018年4月11日 下午6:47:32 
 * @version V1.0   
 *
 */
@Component
public class TimeInterceptor implements HandlerInterceptor{

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	/* （非 Javadoc）
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		request.setAttribute("startTime", new Date().getTime());
		logger.info("preHandle");
		logger.info(((HandlerMethod) handler).getBean().getClass().getName());
		logger.info(((HandlerMethod) handler).getMethod().getName());
		return true;
	}

	/* （非 Javadoc）
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime = (Long) request.getAttribute("startTime");
		logger.info("postHandle");
		logger.info("time interceptor 耗时" + (new Date().getTime() - startTime));
	}

	/* （非 Javadoc）
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		logger.info("afterCompletion");
		logger.info("postHandle");
		long startTime = (Long) request.getAttribute("startTime");
		logger.info("time interceptor 耗时" + (new Date().getTime() - startTime));
		logger.info("ex is "+ex);
	}
	
}

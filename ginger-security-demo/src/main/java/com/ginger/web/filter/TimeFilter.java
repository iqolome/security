/**  
 * 过滤器描述
 * 可以拿到原始http请求和响应信息
 * 拿不到真正处理请求的方法信息
*/
package com.ginger.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:  Time过滤器
 * @author 姜锋
 * @date 2018年4月11日 下午6:26:19 
 * @version V1.0   
 *
 */
//@Component
public class TimeFilter implements Filter {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());

	/* （非 Javadoc）
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		logger.info("Time Filter 初始化开始");
	}

	/* （非 Javadoc）
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Time Filter 开始");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		System.out.println("Time Filter 耗时"+(new Date().getTime()-start));
		System.out.println("Time Filter 完成");
	}

	/* （非 Javadoc）
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("Time Filter 已销毁");
		
	}

}

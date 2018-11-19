/**
 * 
 */
package com.ginger.web.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.ginger.web.filter.TimeFilter;
import com.ginger.web.interceptor.TimeInterceptor;

/**
 * @Description: Web设置
 * @author 姜锋
 * @date 2018年4月11日 下午6:39:46 
 * @version V1.0   
 *
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Autowired
	TimeInterceptor timeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//添加拦截器
		registry.addInterceptor(timeInterceptor);
		super.addInterceptors(registry);
	}
	
	/**
	 * 配置异步支持
	   （非 Javadoc）
	  @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureAsyncSupport(org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer)
	
	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		super.configureAsyncSupport(configurer);
	}
	 */
	
	
	/**
	 * 
	 * @Description: 自定义过滤器 可定义哪个URL拦截
	 * @author 姜锋
	 * @date 2018年4月11日 下午6:45:00
	 * @param @return
	 * @return FilterRegistrationBean
	 * @throws
	 */
	@Bean
	public FilterRegistrationBean timeFilter(){
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);
		List<String> urls = new ArrayList<>();
		//设置被拦截的URL请求
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);
		return registrationBean;
	}
}

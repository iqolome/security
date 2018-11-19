/**
 * 
 */
package com.ginger.security.core.social.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

/**
 * @Description: 绑定结果视图
 * @author 姜锋
 * @date 2018年10月4日 下午4:37:02 
 * @version V1.0   
 *
 */
public class GingerConnectView extends AbstractView {
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		
		if(model.get("connections") != null) {
			response.getWriter().write("<h3>绑定成功</h3>");
		}else {
			response.getWriter().write("<h3>解绑成功</h3>");
		}
		
	}
}

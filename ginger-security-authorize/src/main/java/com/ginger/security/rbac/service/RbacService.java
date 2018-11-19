/**
 * 
 */
package com.ginger.security.rbac.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

/**
 * 
 * @Description: RbacService
 * @author 姜锋
 * @date 2018年10月14日 下午5:59:06 
 * @version V1.0   
 *
 */
public interface RbacService {
	
	boolean hasPermission(HttpServletRequest request, Authentication authentication);

}

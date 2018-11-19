/**
 * 
 */
package com.ginger.security.rbac.service;

import java.util.List;

import com.ginger.security.rbac.dto.RoleInfo;

/**
 * 
 * @Description: 角色服务
 * @author 姜锋
 * @date 2018年10月14日 下午5:59:27 
 * @version V1.0   
 *
 */
public interface RoleService {
	
	/**
	 * 创建角色
	 * @param roleInfo
	 * @return
	 */
	RoleInfo create(RoleInfo roleInfo);
	/**
	 * 修改角色
	 * @param roleInfo
	 * @return
	 */
	RoleInfo update(RoleInfo roleInfo);
	/**
	 * 删除角色
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 获取角色详细信息
	 * @param id
	 * @return
	 */
	RoleInfo getInfo(Long id);
	/**
	 * 查询所有角色
	 * @param condition
	 * @return
	 */
	List<RoleInfo> findAll();
	/**
	 * @param id
	 * @return
	 */
	String[] getRoleResources(Long id);
	/**
	 * @param id
	 * @param ids
	 */
	void setRoleResources(Long id, String ids);

}

/**
 * 
 */
package com.ginger.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.ginger.security.rbac.domain.Role;

/**
 * 
 * @Description:角色
 * @author 姜锋
 * @date 2018年10月14日 下午5:54:35 
 * @version V1.0   
 *
 */
@Repository
public interface RoleRepository extends GingerRepository<Role> {

}

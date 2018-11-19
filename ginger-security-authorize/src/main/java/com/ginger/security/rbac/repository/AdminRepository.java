/**
 * 
 */
package com.ginger.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.ginger.security.rbac.domain.Admin;

/**
 * 
 * @Description: 管理
 * @author 姜锋
 * @date 2018年10月14日 下午5:51:57 
 * @version V1.0   
 *
 */
@Repository
public interface AdminRepository extends GingerRepository<Admin> {

	Admin findByUsername(String username);

}

/**
 * 
 */
package com.ginger.security.rbac.repository;

import org.springframework.stereotype.Repository;

import com.ginger.security.rbac.domain.Resource;

/**
 * 
 * @Description: 资源
 * @author 姜锋
 * @date 2018年10月14日 下午5:53:48 
 * @version V1.0   
 *
 */
@Repository
public interface ResourceRepository extends GingerRepository<Resource> {

	Resource findByName(String name);

}

/**
 * 
 */
package com.ginger.security.rbac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * @Description: GINGER持久化
 * @author 姜锋
 * @date 2018年10月14日 下午5:52:23 
 * @version V1.0   
 *
 * @param <T>
 */
@NoRepositoryBean
public interface GingerRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}

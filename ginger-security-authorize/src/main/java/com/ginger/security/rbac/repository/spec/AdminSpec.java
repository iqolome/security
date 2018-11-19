/**
 * 
 */
package com.ginger.security.rbac.repository.spec;

import com.ginger.security.rbac.domain.Admin;
import com.ginger.security.rbac.dto.AdminCondition;
import com.ginger.security.rbac.repository.support.GingerSpecification;
import com.ginger.security.rbac.repository.support.QueryWraper;

/**
 * 
 * @Description:AdminSpec 
 * @author 姜锋
 * @date 2018年10月14日 下午5:55:11 
 * @version V1.0   
 *
 */
public class AdminSpec extends GingerSpecification<Admin, AdminCondition> {

	public AdminSpec(AdminCondition condition) {
		super(condition);
	}

	@Override
	protected void addCondition(QueryWraper<Admin> queryWraper) {
		addLikeCondition(queryWraper, "username");
	}

}

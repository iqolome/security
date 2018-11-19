/**
 * 
 */
package com.ginger.security.rbac.repository.support;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.spi.MetadataBuildingContext;

/**
 * 
 * @Description: GingerImplicitNamingStrategy
 * @author 姜锋
 * @date 2018年10月14日 下午5:57:46 
 * @version V1.0   
 *
 */
public class GingerImplicitNamingStrategy extends ImplicitNamingStrategyJpaCompliantImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6621998125612738278L;

	@Override
	protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
		return super.toIdentifier("ginger_"+stringForm.toLowerCase(), buildingContext);
	}

}

/**
 * 
 */
package com.ginger.security.rbac.repository.support;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @Description: Domain2InfoConverter
 * @author 姜锋
 * @date 2018年10月14日 下午5:57:23 
 * @version V1.0   
 *
 * @param <T>
 * @param <I>
 */
public interface Domain2InfoConverter<T, I> extends Converter<T, I> {
	
}

/**
 * 
 */
package com.ginger.security.core.validate.code;

import com.ginger.security.core.properties.SecurityConstants;

/**
 * @Description: 校验码类型
 * @author 姜锋
 * @date 2018年9月24日 上午10:04:11 
 * @version V1.0   
 *
 */
public enum ValidateCodeType {
	
	/**
	 * 短信验证码
	 */
	SMS {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
		}
	},
	/**
	 * 图片验证码
	 */
	IMAGE {
		@Override
		public String getParamNameOnValidate() {
			return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
		}
	};

	/**
	 * 校验时从请求中获取的参数的名字
	 * @return
	 */
	public abstract String getParamNameOnValidate();
}

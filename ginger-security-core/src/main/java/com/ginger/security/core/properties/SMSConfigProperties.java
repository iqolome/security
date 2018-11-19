/**
 * 
 */
package com.ginger.security.core.properties;

/**
 * @Description: 短信验证码 服务信息(腾讯云市场服务商)
 * @author 姜锋
 * @date 2018年9月16日 下午7:24:47 
 * @version V1.0   
 *
 */
public class SMSConfigProperties {
	
	
	 private  String SECRET_ID = "AKID604ak2Z6f9nsbne6n0atntmi91xnl2Npsb5g";
	 
	 private  String SECRET_KEY = "7mulzdaUFP9r8UpyrKnU8w40FSktstj50ak0cZbs";
	 /**
      * api发送接口
      * 必填项
      */
	 private  String host = "http://service-4xrmju6b-1255399658.ap-beijing.apigateway.myqcloud.com";
	 private  String path = "/release/dxsms";
	/**
	 * @return sECRET_ID
	 */
	public String getSECRET_ID() {
		return SECRET_ID;
	}
	/**
	 * @param sECRET_ID 要设置的 sECRET_ID
	 */
	public void setSECRET_ID(String sECRET_ID) {
		SECRET_ID = sECRET_ID;
	}
	/**
	 * @return sECRET_KEY
	 */
	public String getSECRET_KEY() {
		return SECRET_KEY;
	}
	/**
	 * @param sECRET_KEY 要设置的 sECRET_KEY
	 */
	public void setSECRET_KEY(String sECRET_KEY) {
		SECRET_KEY = sECRET_KEY;
	}
	/**
	 * @return host
	 */
	public String getHost() {
		return host;
	}
	/**
	 * @param host 要设置的 host
	 */
	public void setHost(String host) {
		this.host = host;
	}
	/**
	 * @return path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path 要设置的 path
	 */
	public void setPath(String path) {
		this.path = path;
	}
	

	
	 
}

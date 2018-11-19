/**
 * 
 */
package com.ginger.security.core.validate.code.sms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ginger.security.core.properties.SecurityProperties;

/**
 * @Description: 短信验证码实现
 * @author 姜锋
 * @date 2018年4月14日 上午10:47:19
 * @version V1.0
 */
public class DefaultSmsCodeSender implements SmsCodeSender {
	
	
	@Autowired
	private SecurityProperties securityProperties;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public void send(String tpl_id, String mobile, String code) {
		try {
			if (null == tpl_id || "" == tpl_id) {
				tpl_id = "TP1801042";
			}
			String param = "code:" + code;
			String url = securityProperties.getCode().getSms().getHost() + securityProperties.getCode().getSms().getPath() + "?mobile=" + mobile
					+ "&tpl_id=" + tpl_id + "&param=" + param;
			logger.info("向手机: "+mobile+", 发送短信验证码: " + code + " ,模板编号为: "+tpl_id);
			CloseableHttpClient httpClient = HttpClients.createDefault();
			// get method
			HttpGet httpGet = new HttpGet(url);
			Date date = new Date();
			httpGet.setHeader("Date", gmtTIME(date));
			String timeStr = "date: " + gmtTIME(date);
			String sign = hmacSHA1Encrypt(timeStr, securityProperties.getCode().getSms().getSECRET_KEY());
			String authStr = "hmac id=\"" + securityProperties.getCode().getSms().getSECRET_ID()
					+ "\",algorithm=\"hmac-sha1\",headers=\"date\", signature=\"" + sign + "\"";
			httpGet.addHeader("Authorization", authStr);
			// response
			HttpResponse response = null;
			response = httpClient.execute(httpGet);
			// get response into String
			String temp = "";
			HttpEntity entity = response.getEntity();
			temp = EntityUtils.toString(entity, "UTF-8");
			ObjectMapper mapper = new ObjectMapper();
			SMSObject sMSObject = mapper.readValue(temp, SMSObject.class);
			// 输出返回值
			System.out.println(temp);
			System.out.println(sMSObject);
		} catch (Exception e) {
			
		}
	}
	/**
	 * HmacSHA1加密
	 * @param encryptText 加密字符串
	 * @param encryptKey 加密key
	 * @return
	 * @throws Exception
	 */
	private String hmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {
		byte[] data = encryptKey.getBytes("UTF-8");
		// 根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
		SecretKey secretKey = new SecretKeySpec(data, "HmacSHA1");
		// 生成一个指定 Mac 算法 的 Mac 对象
		Mac mac = Mac.getInstance("HmacSHA1");
		// 用给定密钥初始化 Mac 对象
		mac.init(secretKey);
		byte[] text = encryptText.getBytes("UTF-8");
		// 完成 Mac 操作,base64编码
		String sign = Base64.encodeBase64String(mac.doFinal(text));
		return sign;
	}
	/**
	 * 获得格林威治时间
	 * @param date 时间
	 * @return
	 */
	private String gmtTIME(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
		// 设置时区为GMT
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		String time = sdf.format(date.getTime());
		return time;
	}
}

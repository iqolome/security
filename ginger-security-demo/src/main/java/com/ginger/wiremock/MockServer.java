/**
 * 
 */
package com.ginger.wiremock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.delete;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathEqualTo;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.ClassPathResource;

/**
 * @Description: MockServer主要连接mock服务端
 * @author 姜锋
 * @date 2018年4月11日 下午9:53:10
 * @version V1.0
 */
public class MockServer {
	/*
	public static void main(String[] args) throws IOException {
		// 指定服务器地址
		configureFor(85);
		// 清空之前的原有配置
		removeAllMappings();
		//参数详解 mock(url,fileName,httpType,httpCode)
		mock("/Special/getPieChar", "00", "GET");
		mock("/Special/getBarChar", "01", "GET");
		mock("/Special/getHeatrChar", "02", "GET");
		mock("/Special/getZoneStatistics", "03", "GET");
		mock("/Special/getPointStatistics", "04", "GET");
		mock("/getIncrement", "05", "GET");
		
	}
	*/
	/**
	 * @throws IOException @Description: 关于配置mock的映射配置 @author 姜锋 @date 2018年4月11日
	 * 下午10:13:52 @param @param string @param @param string2 @return void @throws
	 */
	public  void mock(String url, String fileName, String httpType) throws IOException {
		ClassPathResource resource = new ClassPathResource("/mock/response/" + fileName + ".json");
		String content = StringUtils.join(FileUtils.readLines(resource.getFile(), "UTF-8").toArray(), "/n");
		if (httpType.equals("GET"))
			stubFor(get(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withHeader("Access-Control-Allow-Origin", "*")));
		if (httpType.equals("POST"))
			stubFor(post(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withHeader("Access-Control-Allow-Origin", "*")));
		if (httpType.equals("PUT"))
			stubFor(put(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withHeader("Access-Control-Allow-Origin", "*")));
		if (httpType.equals("DELETE"))
			stubFor(delete(urlPathEqualTo(url)).willReturn(aResponse().withBody(content).withStatus(200)
					.withHeader("Content-Type", "application/json; charset=utf-8").withHeader("Access-Control-Allow-Origin", "*")));
	}
}

/**
 * 
 */
package com.ginger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: SpringBoot启动类
 * @author 姜锋
 * @date 2018年4月10日 上午7:16:47 
 * @version V1.0   
 *
 */
@SpringBootApplication
@RestController
public class DemoApplication {
	
	
	
	/**
	 * 
	 * @Description: 关于启动SpringBoot的配置
	 * @author 姜锋
	 * @date 2018年4月10日 上午7:20:25
	 * @param @param args
	 * @return void
	 * @throws
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@GetMapping("hello")
	public String hello(){
		
		return "hello spring security";
	}
}

/**
 * 
 */
package com.ginger.web.async;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @Description: 异步处理
 * @author 姜锋
 * @date 2018年4月11日 下午8:46:16 
 * @version V1.0   
 *
 */
@RestController
public class AsyncController {
	
	private Logger logger =  LoggerFactory.getLogger(getClass());
	@Autowired
	private MockQuene mockQuene;
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	@RequestMapping("/order")
	public DeferredResult<String> order () throws Exception {
		logger.info("主线程开始");
		String orderNumber = RandomStringUtils.randomNumeric(8);
		
		mockQuene.setPlaceOrder(orderNumber);
		DeferredResult<String> result = new DeferredResult<>();
		 deferredResultHolder.getMap().put(orderNumber, result);
		
		/*Callable<String> result = new Callable<String>() {

			@Override
			public String call() throws Exception {
				logger.info("副线程开始");
				logger.info("副线程返回");
				Thread.sleep(1000);
				return "success";
			}
			
		};*/
		logger.info("主线程返回");
		return result;
		
	}
}

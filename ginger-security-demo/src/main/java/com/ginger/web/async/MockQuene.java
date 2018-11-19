/**
 * 
 */
package com.ginger.web.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description: 测试队列
 * @author 姜锋
 * @date 2018年4月11日 下午8:48:28 
 * @version V1.0   
 *
 */
@Component
public class MockQuene {
	
	// 下单
		private String placeOrder;
		// 订单完成
		private String completeOrder;
		
		private Logger logger = LoggerFactory.getLogger(getClass());

		public String getPlaceOrder() {
			return placeOrder;
		}
		public void setPlaceOrder(String placeOrder) throws Exception {
			new Thread(() -> {
				logger.info("接到下单请求,  " + placeOrder);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.placeOrder = placeOrder;
				this.completeOrder = placeOrder;
				logger.info("下单请求处理完毕, " + placeOrder);
			}).start();
		}
		public String getCompleteOrder() {
			return completeOrder;
		}
		public void setCompleteOrder(String completeOrder) {
			this.completeOrder = completeOrder;
		}
}

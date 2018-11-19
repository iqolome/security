/**
 * 
 */
package com.ginger.web.async;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Description: 队列监听器
 * @author 姜锋
 * @date 2018年4月11日 下午8:50:07 
 * @version V1.0   
 *
 */
@Component
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	private MockQuene mockQuene;
	@Autowired
	private DeferredResultHolder deferredResultHolder;
	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		new Thread(() -> {
			while (true) {
				if (StringUtils.isNotBlank(mockQuene.getCompleteOrder())) {
					String orderNumber = mockQuene.getCompleteOrder();
					logger.info("返回订单处理结果: " + orderNumber);
					deferredResultHolder.getMap().get(orderNumber).setResult("place orders success");
					mockQuene.setCompleteOrder(null);
				} else {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}

package net.fisher.framework.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import net.fisher.project.venue.order.service.ISubscribeDetailService;


/**
 * 服务启动执行
 * @author jinxl
 *
 */
@Component
public class MyStartupRunner  implements CommandLineRunner{

	@Autowired
	private ISubscribeDetailService subscribeDetailService;

	@Override
	public void run(String... args) throws Exception {
		subscribeDetailService.insertBatchDetails();
		
	}

}

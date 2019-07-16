package net.fisher.framework.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import net.fisher.project.venue.order.service.ISubscribeDetailService;

public class OrderInsertSchedule {
	
	@Autowired
	private ISubscribeDetailService subscribeDetailService;
	@Scheduled(cron = "0 0 0 1/1 * ?")
    public void OrderListInsert() {	
		subscribeDetailService.insertBatchDetails();
    }
}

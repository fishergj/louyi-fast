package net.fisher.project.venue.order.mapper;

import java.util.HashMap;
import java.util.List;

import net.fisher.project.venue.order.domain.SubscribeDetail;


public interface SubscribeDetailMapper {
	/**
	 * 批量插入数据
	 * @param list
	 * @return
	 */
	public int  insertBatchDetails(List<SubscribeDetail> list);
	
	/**
	 * 判断时间是否已经存在
	 * @param map
	 * @return
	 */
	int isOrderTimeExist(HashMap<String,Object> map);

}

package net.fisher.project.venue.order.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.fisher.common.utils.CommonUtil;
import net.fisher.common.utils.DateUtil;
import net.fisher.common.utils.TimeUtil;
import net.fisher.project.venue.introduce.domain.Venue;
import net.fisher.project.venue.introduce.mapper.VenueMapper;
import net.fisher.project.venue.order.domain.Subscribe;
import net.fisher.project.venue.order.domain.SubscribeDetail;
import net.fisher.project.venue.order.mapper.SubscribeDetailMapper;
import net.fisher.project.venue.order.mapper.SubscribeMapper;


@Service
public class SubscribeDetailServiceImpl implements ISubscribeDetailService{
	@Autowired
	private VenueMapper venueMapper;
	@Autowired
	private SubscribeMapper subscribeMapper;
	@Autowired
	private SubscribeDetailMapper subscribeDetailMapper;
	
	private int maxDay = 7;
	
	/**
	 * 批量插入预约时间数据
	 * @param list
	 * @return
	 */
	@Transactional
	public void insertBatchDetails() {
		List<Subscribe> list = subscribeMapper.selectAllSubscribes();
		if(list == null || list.size() == 0) return;
		// 根据工作日分组
		Map<Integer, List<Subscribe>> groupBy = list.stream()
				.collect(Collectors.groupingBy(Subscribe::getWeekDay));
		
		// 按日期排序
		groupBy = CommonUtil.sortAscByKey(groupBy);
		
		List<SubscribeDetail> details = new ArrayList<SubscribeDetail>();
		List<Venue> venues = venueMapper.selectAllVenues();
		int venueId = 0;
		if(venues != null && venues.size() > 0)
		{
			venueId = venues.get(0).getId();
		}
		Date currentdt = null;
		try {
			currentdt = DateUtil.parse(DateUtil.getNowTime("yyyy-MM-dd"), "yyyy-MM-dd");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<Integer.valueOf(maxDay);i++){		
			int weekDay = TimeUtil.getWeekIntOfDate(currentdt);
			if(groupBy.containsKey(weekDay)){
				List<Subscribe> times = groupBy.get(weekDay);
				for (Subscribe item : times) {
					HashMap<String,Object> searchObj = new HashMap<String,Object>();
					searchObj.put("subscribeDate", currentdt);
					searchObj.put("subscribeFromDt", item.getFromDt());
					// 不存在 插入
					if(subscribeDetailMapper.isOrderTimeExist(searchObj) == 0){
						SubscribeDetail detail = new SubscribeDetail();
						detail.setWeekDay(weekDay);
						detail.setSubscribeDate(currentdt);
						detail.setSubscribeFromDt(item.getFromDt());
						detail.setSubscribeToDt(item.getToDt());
						detail.setTypePerson(item.getTypePerson());
						detail.setTypeTeam(item.getTypeTeam());
						detail.setEnabled("1");// 可以用
						detail.setVenueId(venueId);// 场馆ID
						details.add(detail);
					}				
				}
			}
			// 获取下一天
			currentdt = DateUtil.getNextDay(currentdt,1);
		}	
		if(details.size() > 0){
			
			subscribeDetailMapper.insertBatchDetails(details);
		}
	
		return;
	}
}

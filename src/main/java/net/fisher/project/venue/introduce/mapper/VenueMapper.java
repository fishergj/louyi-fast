package net.fisher.project.venue.introduce.mapper;

import java.util.List;
import net.fisher.project.venue.introduce.domain.Venue;

/**
 * 场馆介绍 数据层
 * 
 * @author jungao
 * @date Dec 14, 2018 2:03:15 PM
 */
public interface VenueMapper {
	/**
	 * 获取所有的场馆
	 * @return
	 */
	public List<Venue> selectAllVenues();

	
}
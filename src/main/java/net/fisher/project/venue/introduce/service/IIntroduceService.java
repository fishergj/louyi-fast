package net.fisher.project.venue.introduce.service;

import java.util.List;

import net.fisher.project.venue.introduce.domain.Venue;
import net.fisher.project.venue.introduce.domain.VenueIntro;

/**
 * 场馆介绍 服务层
 * 
 * @author jungao
 * @date Dec 14, 2018 2:03:34 PM
 */
public interface IIntroduceService {
	/**
	 * 获取所有的场馆
	 * @return
	 */
	public List<Venue> selectAllVenues();
	/**
	 * 查询场馆介绍信息
	 * 
	 * @param venueIntroId
	 *            场馆介绍ID
	 * @return 场馆介绍信息
	 */
	public VenueIntro selectVenueIntroById(Long venueIntroId);

	/**
	 * 查询场馆介绍列表
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 场馆介绍集合
	 */
	public List<VenueIntro> selectVenueIntroList(VenueIntro venueIntro);

	/**
	 * 新增场馆介绍
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 结果
	 */
	public int insertVenueIntro(VenueIntro venueIntro);

	/**
	 * 修改场馆介绍
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 结果
	 */
	public int updateVenueIntro(VenueIntro venueIntro);

	/**
	 * 删除场馆介绍信息
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteVenueIntroByIds(String ids);
}

package net.fisher.project.venue.introduce.mapper;

import java.util.List;

import net.fisher.project.venue.introduce.domain.VenueIntro;

/**
 * 场馆介绍 数据层
 * 
 * @author jungao
 * @date Dec 14, 2018 2:03:15 PM
 */
public interface IntroduceMapper {
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
	 * 批量删除场馆介绍
	 * 
	 * @param venueIntroIds
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteVenueIntroByIds(String[] venueIntroIds);
}
package net.fisher.project.venue.introduce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.fisher.common.support.Convert;
import net.fisher.project.venue.introduce.domain.Venue;
import net.fisher.project.venue.introduce.domain.VenueIntro;
import net.fisher.project.venue.introduce.mapper.IntroduceMapper;
import net.fisher.project.venue.introduce.mapper.VenueMapper;

/**
 * 场馆介绍 服务层实现
 * 
 * @author jungao
 * @date Dec 14, 2018 2:03:48 PM
 */
@Service
public class IntroduceServiceImpl implements IIntroduceService {
	@Autowired
	private IntroduceMapper introduceMapper;
	@Autowired
	private VenueMapper venueMapper;

	/**
	 * 查询场馆介绍信息
	 * 
	 * @param venueIntroId
	 *            场馆介绍ID
	 * @return 场馆介绍信息
	 */
	@Override
	public VenueIntro selectVenueIntroById(Long venueIntroId) {
		VenueIntro info = introduceMapper.selectVenueIntroById(venueIntroId);
		return info;
	}

	/**
	 * 查询场馆介绍列表
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 场馆介绍集合
	 */
	@Override
	public List<VenueIntro> selectVenueIntroList(VenueIntro venueIntro) {
		return introduceMapper.selectVenueIntroList(venueIntro);
	}

	/**
	 * 新增场馆介绍
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 结果
	 */
	@Override
	public int insertVenueIntro(VenueIntro venueIntro) {
		
		return introduceMapper.insertVenueIntro(venueIntro);
	}

	/**
	 * 修改场馆介绍
	 * 
	 * @param venueIntro
	 *            场馆介绍信息
	 * @return 结果
	 */
	@Override
	public int updateVenueIntro(VenueIntro venueIntro) {
		return introduceMapper.updateVenueIntro(venueIntro);
	}

	/**
	 * 删除场馆介绍对象
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	@Override
	public int deleteVenueIntroByIds(String ids) {
		return introduceMapper.deleteVenueIntroByIds(Convert.toStrArray(ids));
	}

	@Override
	public List<Venue> selectAllVenues() {
		return venueMapper.selectAllVenues();
	}
}

package net.fisher.project.system.user.mapper;

import java.util.List;

import net.fisher.project.system.user.domain.UserPost;

/**
 * 用户与岗位 表 数据层
 * 
 * @author jungao
 * @date Dec 13, 2018 3:46:03 PM
 */
public interface UserPostMapper {
	/**
	 * 通过用户ID删除用户和岗位关联
	 * 
	 * @param userId
	 *            用户ID
	 * @return 结果
	 */
	public int deleteUserPostByUserId(Long userId);

	/**
	 * 通过岗位ID查询岗位使用数量
	 * 
	 * @param postId
	 *            岗位ID
	 * @return 结果
	 */
	public int countUserPostById(Long postId);

	/**
	 * 批量删除用户和岗位关联
	 * 
	 * @param ids
	 *            需要删除的数据ID
	 * @return 结果
	 */
	public int deleteUserPost(Long[] ids);

	/**
	 * 批量新增用户岗位信息
	 * 
	 * @param userPostList
	 *            用户角色列表
	 * @return 结果
	 */
	public int batchUserPost(List<UserPost> userPostList);
}

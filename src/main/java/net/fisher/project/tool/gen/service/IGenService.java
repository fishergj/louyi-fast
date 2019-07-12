package net.fisher.project.tool.gen.service;

import java.util.List;

import net.fisher.project.tool.gen.domain.TableInfo;

/**
 * 代码生成 服务层
 * 
 * @author jungao
 * @date Dec 8, 2018 1:20:22 PM
 */
public interface IGenService {
	/**
	 * 查询数据库表信息
	 * 
	 * @param tableInfo
	 *            表信息
	 * @return 数据库表列表
	 */
	public List<TableInfo> selectTableList(TableInfo tableInfo);

	/**
	 * 生成代码
	 * 
	 * @param tableName
	 *            表名称
	 * @return 数据
	 */
	public byte[] generatorCode(String tableName);

	/**
	 * 批量生成代码
	 * 
	 * @param tableNames
	 *            表数组
	 * @return 数据
	 */
	public byte[] generatorCode(String[] tableNames);
}

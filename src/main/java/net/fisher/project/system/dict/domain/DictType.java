package net.fisher.project.system.dict.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.fisher.framework.web.domain.BaseEntity;

/**
 * 字典类型对象 sys_dict_type
 * 
 * @author jungao
 * @date Dec 13, 2018 4:24:03 PM
 */
public class DictType extends BaseEntity {
	private static final long serialVersionUID = 1L;

	/** 字典主键 */
	private Long dictId;

	/** 字典名称 */
	private String dictName;

	/** 字典类型 */
	private String dictType;

	/** 状态（0正常 1停用） */
	private String status;

	public Long getDictId() {
		return dictId;
	}

	public void setDictId(Long dictId) {
		this.dictId = dictId;
	}

	public String getDictName() {
		return dictName;
	}

	public void setDictName(String dictName) {
		this.dictName = dictName;
	}

	public String getDictType() {
		return dictType;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("dictId", getDictId())
				.append("dictName", getDictName()).append("dictType", getDictType()).append("status", getStatus())
				.append("createBy", getCreateBy()).append("createTime", getCreateTime())
				.append("updateBy", getUpdateBy()).append("updateTime", getUpdateTime()).append("remark", getRemark())
				.toString();
	}
}

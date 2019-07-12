package net.fisher.framework.web.page;

import net.fisher.common.constant.Constants;
import net.fisher.common.utils.ServletUtils;

/**
 * 表格数据处理
 * 
 * @author jungao
 * @date Dec 8, 2018 1:33:30 PM
 */
public class TableSupport {
	/**
	 * 封装分页对象
	 */
	public static PageDomain getPageDomain() {
		PageDomain pageDomain = new PageDomain();
		pageDomain.setPageNum(ServletUtils.getParameterToInt(Constants.PAGE_NUM));
		pageDomain.setPageSize(ServletUtils.getParameterToInt(Constants.PAGE_SIZE));
		pageDomain.setOrderByColumn(ServletUtils.getParameter(Constants.ORDER_BY_COLUMN));
		pageDomain.setIsAsc(ServletUtils.getParameter(Constants.IS_ASC));
		return pageDomain;
	}

	public static PageDomain buildPageRequest() {
		return getPageDomain();
	}

}

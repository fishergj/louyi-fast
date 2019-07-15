package net.fisher.project.venue.introduce.controller;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.fisher.framework.aspectj.lang.annotation.Log;
import net.fisher.framework.aspectj.lang.enums.BusinessType;
import net.fisher.framework.web.controller.BaseController;
import net.fisher.framework.web.domain.AjaxResult;
import net.fisher.framework.web.page.TableDataInfo;
import net.fisher.project.venue.introduce.domain.VenueIntro;
import net.fisher.project.venue.introduce.service.IIntroduceService;

/**
 * 场馆介绍 信息操作处理
 * 
 * @author jungao
 * @date Dec 14, 2018 2:04:04 PM
 */
@Controller
@RequestMapping("/venue/introduce")
public class IntroduceController extends BaseController {
	private String prefix = "venue/introduce";

	@Autowired
	private IIntroduceService introduceService;

	@RequiresPermissions("system:introduce:view")
	@GetMapping()
	public String venueIntro() {
		return prefix + "/index";
	}

	/**
	 * 查询场馆介绍列表
	 */
	@RequiresPermissions("system:introduce:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(VenueIntro venueIntro) {
		startPage();
		List<VenueIntro> list = introduceService.selectVenueIntroList(venueIntro);
		return getDataTable(list);
	}

	/**
	 * 新增场馆介绍
	 */
	@GetMapping("/add")
	public String add(ModelMap mmap) {
		mmap.put("venues", introduceService.selectAllVenues());
		return prefix + "/add";
	}

	/**
	 * 新增保存场馆介绍
	 */
	@RequiresPermissions("system:introduce:add")
	@Log(title = "通知场馆介绍", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(VenueIntro venueIntro) {
		return toAjax(introduceService.insertVenueIntro(venueIntro));
	}

	/**
	 * 修改场馆介绍
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, ModelMap mmap) {
		mmap.put("venueIntro", introduceService.selectVenueIntroById(id));
		mmap.put("venues", introduceService.selectAllVenues());
		return prefix + "/edit";
	}

	/**
	 * 修改保存场馆介绍
	 */
	@RequiresPermissions("system:introduce:edit")
	@Log(title = "通知场馆介绍", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(VenueIntro venueIntro) {
		return toAjax(introduceService.updateVenueIntro(venueIntro));
	}

	/**
	 * 删除场馆介绍
	 */
	@RequiresPermissions("system:introduce:remove")
	@Log(title = "通知场馆介绍", businessType = BusinessType.DELETE)
	@PostMapping("/remove")
	@ResponseBody
	public AjaxResult remove(String ids) {
		return toAjax(introduceService.deleteVenueIntroByIds(ids));
	}
}

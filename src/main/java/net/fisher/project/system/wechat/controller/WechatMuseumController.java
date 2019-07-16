package net.fisher.project.system.wechat.controller;

import net.fisher.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 场馆介绍
 */
@Controller
@RequestMapping("/wechat/meseum")
public class WechatMuseumController extends BaseController {

    private String prefix = "system/museum";

    /**
     * 场馆概述
     * @return
     */
    @RequestMapping("/intro")
    public String introVenue() {
        return prefix + "/intro";
    }

    /**
     * 场馆导览
     * @return
     */
    @RequestMapping("/guide")
    public String guideVenue() {
        return "";
    }

    /**
     * 展品介绍
     * @return
     */
    @RequestMapping("/exhibit")
    public String introExhibit() {
        return "";
    }

    /**
     * 精彩瞬间
     * @return
     */
    @RequestMapping("/moment")
    public String queryMoment() {
        return "";
    }

}

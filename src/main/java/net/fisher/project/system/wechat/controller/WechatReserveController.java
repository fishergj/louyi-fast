package net.fisher.project.system.wechat.controller;

import net.fisher.framework.web.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wechat/reserve")
public class WechatReserveController extends BaseController {
    private String prefix = "/system/reserve";

    /**
     * 参观预约
     * @return
     */
    public String doReserve() {
        return "";
    }

    /**
     * 预约查询
     * @return
     */
    public String checkReserve() {
        return "";
    }

    /**
     * 一键导航
     * @return
     */
    public String navigate() {
        return "";
    }

    /**
     * 留言建议
     * @return
     */
    public String recommend() {
        return "";
    }
}

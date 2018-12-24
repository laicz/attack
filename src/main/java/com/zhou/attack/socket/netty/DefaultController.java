package com.zhou.attack.socket.netty;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoumb on 2018/12/20
 */
@Controller
public class DefaultController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}

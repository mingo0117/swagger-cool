package com.mingo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Copyright@www.jd.com
 * Author:mingo
 * Date:2018/5/24 13:32
 * Description:强制调转到swagger测试页
 */
@Controller
public class Home {
    @RequestMapping("/")
    public String home() {
        return "redirect:swagger-ui.html";
    }
}

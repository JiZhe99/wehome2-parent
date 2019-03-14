package com.czxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/2/26 0026.
 */
@Controller
public class IndexController {

    @RequestMapping("/{path}")
    public String index(@PathVariable String path){
        return  path;
    }

    @RequestMapping("/pages/{dir}/{path}")
    public String home2(@PathVariable("dir") String d ,@PathVariable("path") String p){
        return "/pages/" + d + "/" + p;
    }
}

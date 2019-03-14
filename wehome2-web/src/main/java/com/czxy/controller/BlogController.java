package com.czxy.controller;

import com.czxy.domain.Blog;
import com.czxy.service.BlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/7 0007.
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Resource
    private BlogService blogService;

    @GetMapping("/findAll")
    public List<Blog> findByBlog(){
        List<Blog> list = blogService.findAll();
        return  list;
    }
}

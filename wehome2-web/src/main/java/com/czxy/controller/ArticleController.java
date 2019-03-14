package com.czxy.controller;

import com.czxy.domain.Article;
import com.czxy.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/2/28 0028.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/findAll")
    public List<Article> findByArticle(){
        List<Article> list = articleService.findAll();
        return list;
    }

}

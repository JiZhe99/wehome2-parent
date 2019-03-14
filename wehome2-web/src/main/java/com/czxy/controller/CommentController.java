package com.czxy.controller;

import com.czxy.domain.Comment;
import com.czxy.service.CommentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private CommentService commentService;

    @GetMapping("/findAll")
    public List<Comment> findByComment(){
        List<Comment> list = commentService.findAll();
        return  list;
    }
}

package com.czxy.service;

import com.czxy.dao.CommentMapper;
import com.czxy.domain.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
@Service
@Transactional
public class CommentService {

    @Resource
    private CommentMapper commentMapper;

    public List<Comment> findAll(){
        List<Comment> list = commentMapper.selectAll();
        return  list;
    }
}

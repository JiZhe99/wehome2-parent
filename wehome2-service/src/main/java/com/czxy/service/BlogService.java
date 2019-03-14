package com.czxy.service;

import com.czxy.dao.BlogMapper;
import com.czxy.domain.Blog;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/7 0007.
 */
@Service
@Transactional
public class BlogService {

    @Resource
    private BlogMapper blogMapper;

    public List<Blog> findAll(){
        List<Blog> list = blogMapper.selectAll();
        return  list;
    }
}

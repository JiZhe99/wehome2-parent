package com.czxy.service;

import com.czxy.dao.ArticleMapper;
import com.czxy.domain.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/2/28 0028.
 */
@Service
@Transactional
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public List<Article> findAll(){
        return  articleMapper.selectAll();
    }
}

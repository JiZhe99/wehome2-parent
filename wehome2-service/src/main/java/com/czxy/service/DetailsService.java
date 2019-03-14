package com.czxy.service;

import com.czxy.dao.DetailsMapper;
import com.czxy.domain.Details;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@Service
@Transactional
public class DetailsService {

    @Resource
    private DetailsMapper detailsMapper;

    public List<Details> findAll(){
        List<Details> list = detailsMapper.selectAll();
        return  list;
    }

}

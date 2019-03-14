package com.czxy.service;

import com.czxy.dao.MajorMapper;
import com.czxy.domain.Major;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Service
@Transactional
public class MajorService {

    @Resource
    private MajorMapper majorMapper;

    public List<Major> findAll(){
        return  majorMapper.selectAll();
    }

}

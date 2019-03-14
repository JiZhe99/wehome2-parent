package com.czxy.controller;

import com.czxy.domain.Details;
import com.czxy.service.DetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/5 0005.
 */
@RestController
@RequestMapping("/details")
public class DetailsController {

    @Resource
    private DetailsService detailsService;

    @GetMapping("/findAll")
    public List<Details> findByDetails(){
        List<Details> list = detailsService.findAll();
        return  list;
    }

}

package com.czxy.controller;

import com.czxy.domain.Major;
import com.czxy.service.MajorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**x`
 * Created by Administrator on 2019/2/27 0027.
 */
@RestController
@RequestMapping("/major")
public class MajorController {

    @Resource
    private MajorService majorService;

    @GetMapping("/findAll")
    public List<Major> findByMajor(){
        List<Major> list = majorService.findAll();
        return  list;
    }
}

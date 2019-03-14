package com.czxy.controller;

import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/findAll")
    public List<Product> findByProduct(){
        List<Product> list = productService.findAll();
        return  list;
    }

}

package com.czxy.service;

import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/4 0004.
 */
@Service
@Transactional
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    public List<Product> findAll(){
        List<Product> products = productMapper.selectAll();
        return  products;
    }

}

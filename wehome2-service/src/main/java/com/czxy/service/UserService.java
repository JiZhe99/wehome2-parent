package com.czxy.service;

import com.czxy.dao.UserMapper;
import com.czxy.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@Service
@Transactional
public class UserService {

    @Resource
    private UserMapper userMapper;

    public User login(String username,String password) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username).andEqualTo("password", password);
        User users = userMapper.selectOneByExample(example);
        return users;
    }
}

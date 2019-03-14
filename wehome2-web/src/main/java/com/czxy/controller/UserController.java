package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/1 0001.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<String> login(String username, String password){

        User user = userService.login(username, password);
        if(user!=null){
            return  new ResponseEntity<String>("登录成功", HttpStatus.OK);
        }
        return new ResponseEntity<String>("用户名或密码错误",HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

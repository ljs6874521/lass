package com.ljs.demo.controller;

import com.ljs.demo.Service.UserService;
import com.ljs.demo.common.response.ResponseMessage;
import com.ljs.demo.pojo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping(value = "/findAll")
    public ResponseMessage findAll(){
        List<User> list =  userService.findAll();
        log.info("|对外接口|返回参数[{}]", list);
        User user = list.get(1);
        redisTemplate.opsForValue().set("ljs",user);
        System.out.println(redisTemplate.opsForValue().get("ljs"));
        return ResponseMessage.ok("用户链表",list);
    }
}

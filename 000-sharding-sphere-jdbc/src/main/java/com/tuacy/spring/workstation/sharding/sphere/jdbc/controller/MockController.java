package com.tuacy.spring.workstation.sharding.sphere.jdbc.controller;

import com.tuacy.common.entity.web.controller.BaseController;
import com.tuacy.common.entity.web.response.ResponseResult;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.User;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:22.
 */
@RestController
@RequestMapping("/v1/mock")
@Slf4j
public class MockController extends BaseController {

    @Resource
    private UserMapper userMapper;

    /**
     * 测试函数
     *
     * @return 是否成功
     */
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseResult<Void> addUser() {
        User user = new User();
        user.setBirthday("19890818");
        user.setId(1L);
        user.setNickname("tuacy");
        user.setPassword("123456");
        user.setSex(1);
        userMapper.insertUser(user);

        return setResponseResult();
    }
}

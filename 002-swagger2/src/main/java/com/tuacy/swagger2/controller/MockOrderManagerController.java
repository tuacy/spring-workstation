package com.tuacy.swagger2.controller;

import com.tuacy.swagger2.param.UserInfoParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller测试
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/19 8:50.
 */
@RestController
@RequestMapping("/v1/mock")
@Slf4j
@Api(tags = "订单管理")
public class MockOrderManagerController {

    /**
     * 保存数据
     *
     * @param user 用户信息
     * @return 请求结果
     */
    @PostMapping(value = "/addUser")
    // 方法参数说明，name参数名；value参数说明，备注；dataType参数类型；required 是否必传；defaultValue 默认值
    @ApiImplicitParam(name = "user", value = "新增用户数据")
    // 说明是什么方法(可以理解为方法注释)
    @ApiOperation(value = "添加用户", notes = "添加用户")
    public String addUser(@RequestBody UserInfoParam user) {
        return "添加用户成功";
    }

}

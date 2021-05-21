package com.tuacy.swagger2.param;

import io.swagger.annotations.ApiModelProperty;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/19 8:54.
 */
public class UserInfoParam {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true, example = "wuyx")
    private String name;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserInfoParam{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model;

import lombok.Data;

/**
 * @author wuyx
 * @version 1.0
 * @date 2021/12/17 20:58
 */
@Data
public class User {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别 0：男性，1：女性
     */
    private int sex;
    /**
     * 生日
     */
    private String birthday;

}

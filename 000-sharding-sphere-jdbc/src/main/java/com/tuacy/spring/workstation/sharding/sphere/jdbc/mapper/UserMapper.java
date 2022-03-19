package com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户表对应的mapper
 *
 * @author wuyx
 * @version 1.0
 * @date 2021/12/17 21:00
 */
public interface UserMapper {

    /**
     * 插入用户
     * @param item 用户信息
     * @return 插入条数
     */
    int insertUser(@Param("item") User item);

}

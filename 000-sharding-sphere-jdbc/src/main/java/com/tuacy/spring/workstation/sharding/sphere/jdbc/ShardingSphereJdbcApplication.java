package com.tuacy.spring.workstation.sharding.sphere.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:04.
 */
@SpringBootApplication
@MapperScan("com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper")
public class ShardingSphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcApplication.class, args);
    }

}

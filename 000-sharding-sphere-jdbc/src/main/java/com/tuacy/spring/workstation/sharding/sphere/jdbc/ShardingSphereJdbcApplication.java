package com.tuacy.spring.workstation.sharding.sphere.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.transaction.jta.JtaAutoConfiguration;

/**
 * 启动类
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:04.
 */
@SpringBootApplication(exclude = JtaAutoConfiguration.class)
@MapperScan("com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper")
public class ShardingSphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcApplication.class, args);
    }

}

package com.tuacy.srping.workstation.sharding.shpre.jdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * https://blog.csdn.net/zjy_love_java/article/details/107306924
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:04.
 */
@SpringBootApplication
public class ShardingSphereJdbcApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcApplication.class, args);
    }

}

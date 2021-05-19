package com.tuacy.fastdfs;

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
public class FastDFSApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastDFSApplication.class, args);
    }

}

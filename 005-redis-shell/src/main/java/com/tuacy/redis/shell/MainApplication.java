package com.tuacy.redis.shell;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 主启动类
 *
 * @author wuyx
 * @version 1.0
 * @date 2022/3/19 19:30
 */
@SpringBootApplication
public class MainApplication {

    /**
     * 主函数
     *
     * @param args 启动参数信息
     */
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MainApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);
    }

}

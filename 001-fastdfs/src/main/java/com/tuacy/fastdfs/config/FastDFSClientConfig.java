package com.tuacy.fastdfs.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * 文件服务器配置类
 * 只需要一行注解 @Import(FdfsClientConfig.class)就可以拥有带有连接池的FastDFS Java客户端了
 * 如果不加 spring.jmx.enabled=false 和 @EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING) 启动项目时会报异常:
 * 推荐使用 : @EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
 *
 * 主要接口包括
 *
 * TrackerClient - TrackerServer接口
 * GenerateStorageClient - 一般文件存储接口 (StorageServer接口)
 * FastFileStorageClient - 为方便项目开发集成的简单接口(StorageServer接口)
 * AppendFileStorageClient - 支持文件续传操作的接口 (StorageServer接口)
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/20 20:04.
 */
@Configuration
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDFSClientConfig {
}

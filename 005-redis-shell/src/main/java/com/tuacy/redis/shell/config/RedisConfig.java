package com.tuacy.redis.shell.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.ObjectUtils;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redission 配置
 *
 * @author wuyx
 * @version 1.0
 * @date 2022/3/19 19:43
 */
@Slf4j
@Configuration
public class RedisConfig {

    /**
     * 连接池最大连接数（使用负值表示没有限制）
     */
    @Value("${spring.redis.jedis.pool.max-active:-1}")
    private int maxActive;
    /**
     * 连接池最大阻塞等待时间（使用负值表示没有限制）
     */
    @Value("${spring.redis.jedis.pool.max-wait:-1}")
    private long maxWait;
    /**
     * 连接池中的最大空闲连接
     */
    @Value("${spring.redis.jedis.pool.max-idle:8}")
    private int maxIdle;
    /**
     * 连接池中的最小空闲连接
     */
    @Value("${spring.redis.jedis.pool.min-idle:0}")
    private int minIdle;


    /**
     * 是负责建立Factory的连接工厂类
     *
     * @param hostName redis ip
     * @param password redis password
     * @param port     redis port
     * @param database redis database
     * @return RedisConnectionFactory
     */
    public RedisConnectionFactory getRedisConnectionFactory(
            String hostName,
            String password,
            int port,
            int database
    ) {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(hostName);
        factory.setPort(port);
        if (!ObjectUtils.isEmpty(password)) {
            factory.setPassword(password);
        }
        factory.setDatabase(database);
        // 进行连接池配置
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxActive);
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxWaitMillis(maxWait);
        factory.setPoolConfig(poolConfig);
        // 初始化连接池配置
        factory.afterPropertiesSet();
        return factory;
    }

    /**
     * VIP 对应的redis
     *
     * @param hostName redis ip
     * @param port     redis port
     * @param password redis password
     * @param database redis database
     * @return RedisTemplate
     */
    @Bean("vipRedisTemplate")
    public RedisTemplate<String, String> vipRedisTemplate(
            @Value("${spring.redis.connect.vip.host}") String hostName,
            @Value("${spring.redis.connect.vip.port}") int port,
            @Value("${spring.redis.connect.vip.password}") String password,
            @Value("${spring.redis.connect.vip.database}") int database
    ) {
        // 建立Redis的连接
        RedisConnectionFactory factory = this.getRedisConnectionFactory(hostName, password, port, database);
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // key的序列化类型
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    /**
     * IP1 对应的redis
     *
     * @param hostName redis ip
     * @param port     redis port
     * @param password redis password
     * @param database redis database
     * @return RedisTemplate
     */
    @Bean("ip1RedisTemplate")
    public RedisTemplate<String, String> ip1RedisTemplate(
            @Value("${spring.redis.connect.ip1.host}") String hostName,
            @Value("${spring.redis.connect.ip1.port}") int port,
            @Value("${spring.redis.connect.ip1.password}") String password,
            @Value("${spring.redis.connect.ip1.database}") int database
    ) {
        // 建立Redis的连接
        RedisConnectionFactory factory = this.getRedisConnectionFactory(hostName, password, port, database);
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // key的序列化类型
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

    /**
     * IP2 对应的redis
     *
     * @param hostName redis ip
     * @param port     redis port
     * @param password redis password
     * @param database redis database
     * @return RedisTemplate
     */
    @Bean("ip2RedisTemplate")
    public RedisTemplate<String, String> ip2RedisTemplate(
            @Value("${spring.redis.connect.ip2.host}") String hostName,
            @Value("${spring.redis.connect.ip2.port}") int port,
            @Value("${spring.redis.connect.ip2.password}") String password,
            @Value("${spring.redis.connect.ip2.database}") int database
    ) {
        // 建立Redis的连接
        RedisConnectionFactory factory = this.getRedisConnectionFactory(hostName, password, port, database);
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // key的序列化类型
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value的序列化类型
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}

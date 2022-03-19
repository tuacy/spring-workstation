package com.tuacy.redis.shell.command;

import cn.hutool.core.date.DateUtil;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * redis 测试相关命令
 *
 * @author wuyx
 * @version 1.0
 * @date 2022/3/19 21:28
 */
@ShellComponent
public class RedisShellCommand {

    /**
     * 线程池
     */
    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(
            0, Integer.MAX_VALUE,
            60L, TimeUnit.SECONDS,
            new SynchronousQueue<>(), r -> new Thread(r, "[redis读取数据线程]" + r.hashCode())
    );

    /**
     * Redis对应的key
     */
    private static final String KEY_REDIS_SHELL_COMMAND = "redis-shell";

    /**
     * VIP 对应的redis客户端（用于写数据）
     */
    private RedisTemplate<String, String> vipRedisTemplate;
    /**
     * IP1 对应的redis客户端（用于读数据）
     */
    private RedisTemplate<String, String> ip1RedisTemplate;
    /**
     * IP2 对应的redis客户端（用于读数据）
     */
    private RedisTemplate<String, String> ip2RedisTemplate;

    @Resource(name = "vipRedisTemplate")
    public void setVipRedisTemplate(RedisTemplate<String, String> vipRedisTemplate) {
        this.vipRedisTemplate = vipRedisTemplate;
    }

    @Resource(name = "ip1RedisTemplate")
    public void setIp1RedisTemplate(RedisTemplate<String, String> ip1RedisTemplatet) {
        this.ip1RedisTemplate = ip1RedisTemplatet;
    }

    @Resource(name = "ip2RedisTemplate")
    public void setIp2RedisTemplate(RedisTemplate<String, String> ip2RedisTemplate) {
        this.ip2RedisTemplate = ip2RedisTemplate;
    }

    /**
     * 测试命令，对一个值一直做累加操作，vipRedissionClient用于写数据，ip1RedissionClient，ip2RedissionClient用于读数据
     *
     * @param initValue    初始值
     * @param stepValue    步长，每次加
     * @param lastingTime  持续多长时间 单位秒
     * @param intervalTime 每次间隔多长时间下发一次命令 单位秒
     */
    @ShellMethod("Redis Keepalived 测试命令")
    public void redis(long initValue, long stepValue, long lastingTime, long intervalTime) {

        if (lastingTime <= 0 || intervalTime <= 0) {
            System.out.println("参数不合法");
            return;
        }

        JedisConnectionFactory vipConnectFactory = (JedisConnectionFactory) vipRedisTemplate.getConnectionFactory();
        JedisConnectionFactory ip1ConnectFactory = (JedisConnectionFactory) ip1RedisTemplate.getConnectionFactory();
        JedisConnectionFactory ip2ConnectFactory = (JedisConnectionFactory) ip2RedisTemplate.getConnectionFactory();
        if (vipConnectFactory == null || ip1ConnectFactory == null || ip2ConnectFactory == null) {
            System.out.println("初始化程序失败");
            return;
        }
        System.out.println(String.format("%s 开始测试，初始值：%d, 步长：%d, 持续时间：%d秒, 间隔时间：%d秒", DateUtil.formatLocalDateTime(LocalDateTime.now()), initValue, stepValue, lastingTime, intervalTime));
        /*
        设置初始值
         */
        vipRedisTemplate.opsForValue().set(KEY_REDIS_SHELL_COMMAND, String.valueOf(initValue));
        long endTime = System.currentTimeMillis() + lastingTime * 1000;
        int loopIndex = 0;
        while (System.currentTimeMillis() < endTime) {
            /*
            写数据
             */
            loopIndex = loopIndex + 1;
            System.out.println("\n");
            System.out.println(String.format("---------------- 第(%d)次写入 ----------------", loopIndex));
            Long baseValue;
            try {
                baseValue = vipRedisTemplate.opsForValue().increment(KEY_REDIS_SHELL_COMMAND, stepValue);
            } catch (Exception ex) {
                System.out.println(String.format("%s %s 第 %d 次写入，写入基准值失败", DateUtil.formatLocalDateTime(LocalDateTime.now()), vipConnectFactory.getHostName(), loopIndex));
                continue;
            }
            if (baseValue == null) {
                System.out.println("没有使用pipe的方式，永远都不会走到这里");
                continue;
            }
            System.out.println(String.format("%s %s 第(%d)次写入值：%d", DateUtil.formatLocalDateTime(LocalDateTime.now()), vipConnectFactory.getHostName(), loopIndex, baseValue));
            /*
            读取数据
             */
            int loopTemp = loopIndex;
            // ip1
            EXECUTOR.submit(() -> {
                String ip1Value;
                try {
                    ip1Value = ip1RedisTemplate.opsForValue().get(KEY_REDIS_SHELL_COMMAND);
                } catch (Exception ex) {
                    System.out.println(String.format("%s %s 读取第(%d)次读写入的是失败", DateUtil.formatLocalDateTime(LocalDateTime.now()), ip1ConnectFactory.getHostName(), loopTemp));
                    return;
                }
                System.out.println(String.format("%s %s 第(%d)次读(写入值：读取值) - (%d, %s)", DateUtil.formatLocalDateTime(LocalDateTime.now()), ip1ConnectFactory.getHostName(), loopTemp, baseValue, ObjectUtils.isEmpty(ip1Value) ? "" : ip1Value));
            });
            // ip2
            EXECUTOR.submit(() -> {
                String ip1Value;
                try {
                    ip1Value = ip2RedisTemplate.opsForValue().get(KEY_REDIS_SHELL_COMMAND);
                } catch (Exception ex) {
                    System.out.println(String.format("%s %s 第(%d)次读写入的是失败", DateUtil.formatLocalDateTime(LocalDateTime.now()), ip2ConnectFactory.getHostName(), loopTemp));
                    return;
                }
                System.out.println(String.format("%s %s 第(%d)次读(写入值：读取值) - (%d, %s)", DateUtil.formatLocalDateTime(LocalDateTime.now()), ip2ConnectFactory.getHostName(), loopTemp, baseValue, ObjectUtils.isEmpty(ip1Value) ? "" : ip1Value));
            });
            /*
            延时等待下一次的写入
             */
            try {
                Thread.sleep(intervalTime * 1000);
            } catch (Exception ignore) {

            }

        }
    }

}

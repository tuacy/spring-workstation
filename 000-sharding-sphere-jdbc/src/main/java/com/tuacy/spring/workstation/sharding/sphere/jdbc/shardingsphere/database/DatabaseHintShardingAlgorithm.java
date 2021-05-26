package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.database;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.ShardingSphereConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.sharding.api.sharding.hint.HintShardingValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/25 20:12.
 */
@Slf4j
public class DatabaseHintShardingAlgorithm implements HintShardingAlgorithm<Integer> {

    /**
     * 配置文件里面配置的自定义参数
     */
    private Properties props = new Properties();

    /**
     * 实现范围分片
     *
     * @param availableTargetNames 所有的可用分片资源集合
     * @param shardingValue        所有的可用分片资源集合
     * @return 分库后指向的数据源名称集合
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<Integer> shardingValue) {
        List<String> shardingResult = new ArrayList<>();

        shardingResult.add("history");

        return shardingResult;
    }

    @Override
    public void init() {
        log.info("分库策略初始化");
    }

    @Override
    public String getType() {
        return ShardingSphereConstants.ShardingType.DATABASE_SHARDING_TYPE;
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void setProps(Properties properties) {
        this.props = properties;
    }
}

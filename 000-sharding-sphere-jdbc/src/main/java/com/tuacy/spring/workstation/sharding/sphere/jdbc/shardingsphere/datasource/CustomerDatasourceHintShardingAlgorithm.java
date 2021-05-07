package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.datasource;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.ShardingSphereConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.HashSet;

/**
 * 自定义分库规则
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:55.
 */
@Slf4j
public class CustomerDatasourceHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        log.info(hintShardingValue.getLogicTableName());
        Collection<String> result = new HashSet<>();
        result.add(ShardingSphereConstants.DataSource.DATA_SOURCE_HISTORY);
        return result;
    }
}
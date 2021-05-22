package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.datasource;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.ShardingSphereConstants;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.*;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 16:27.
 */
public class CustomerDataBasePreciseShardingAlgorithm implements StandardShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        // 实现精确分片
        for (Map.Entry<String, List<String>> entryItem : ShardingSphereConstants.dataSourceTable.entrySet()) {
            if (entryItem.getValue().contains(shardingValue.getLogicTableName())) {
                return entryItem.getKey();
            }
        }
        throw new IllegalArgumentException("分库异常");
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Integer> shardingValue) {
        // 实现范围分片
        Collection<String> result = new HashSet<>();
        for (Map.Entry<String, List<String>> entryItem : ShardingSphereConstants.dataSourceTable.entrySet()) {
            if (entryItem.getValue().contains(shardingValue.getLogicTableName())) {
                result.add(entryItem.getKey());
                return result;
            }
        }
        throw new IllegalArgumentException("分库异常");
    }

    @Override
    public void init() {

    }

    @Override
    public String getType() {
        // 作为该分片策略的 key
        return null;
    }

    @Override
    public Properties getProps() {
        return null;
    }

    @Override
    public void setProps(Properties properties) {

    }
}

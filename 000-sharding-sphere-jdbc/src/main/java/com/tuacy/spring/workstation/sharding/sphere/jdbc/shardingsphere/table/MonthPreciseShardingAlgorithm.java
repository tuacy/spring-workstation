package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.table;


import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 按月分表
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 16:27.
 */
public class MonthPreciseShardingAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        StringBuilder tableName = new StringBuilder();
        String monthKey = shardingValue.getValue().substring(0, "yyyy-mm".length()).replace("-", "");
        tableName.append(shardingValue.getLogicTableName()).append("_").append(monthKey);
        return tableName.toString();
    }
}

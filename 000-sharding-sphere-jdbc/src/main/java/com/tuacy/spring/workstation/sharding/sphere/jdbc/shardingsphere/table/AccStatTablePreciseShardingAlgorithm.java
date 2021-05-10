package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.table;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 16:27.
 */
public class AccStatTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        return "stat_acc";
    }
}

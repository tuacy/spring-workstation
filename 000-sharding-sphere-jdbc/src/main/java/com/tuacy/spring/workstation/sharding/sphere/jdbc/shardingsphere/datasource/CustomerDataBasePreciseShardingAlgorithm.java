package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.datasource;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.ShardingSphereConstants;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 16:27.
 */
public class CustomerDataBasePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Integer> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Integer> shardingValue) {
        return ShardingSphereConstants.DataSource.DATA_SOURCE_HISTORY;
    }
}

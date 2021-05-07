package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.table;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.HashSet;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 15:58.
 */
public class AccHistroyTableHintShardingAlgorithm implements HintShardingAlgorithm<String> {

    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        Collection<String> result = new HashSet<>();
        result.add("t_order_2");
        return result;
    }
}

package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

import java.util.Collection;
import java.util.HashSet;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:55.
 */
@Slf4j
public class MyDatasourceRoutingAlgorithm implements HintShardingAlgorithm<String> {

    /**
     * 用户数据源
     */
    private static final String DS_HISTORY = "history";

    /**
     * 订单数据源
     */
    private static final String DS_STAT = "stat";


    @Override
    public Collection<String> doSharding(Collection<String> collection, HintShardingValue<String> hintShardingValue) {
        Collection<String> result = new HashSet<>();
        if (hintShardingValue.getLogicTableName().startsWith("history")) {
            result.add(DS_HISTORY);
        } else {
            result.add(DS_STAT);
        }
        return result;
    }
}

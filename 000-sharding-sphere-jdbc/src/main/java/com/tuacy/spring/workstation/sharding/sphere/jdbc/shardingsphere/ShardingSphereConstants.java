package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 15:51.
 */
public interface ShardingSphereConstants {


    interface DataSource {
        String DATA_SOURCE_HISTORY = "history";
        String DATA_SOURCE_STAT = "stat";
    }

    interface LogicTable {
        String HISTORY = "history";
        String STAT = "stat";
    }

    Map<String, List<String>> dataSourceTable = new HashMap<String, List<String>>() {{
        put(DataSource.DATA_SOURCE_HISTORY, Lists.newArrayList(LogicTable.HISTORY));
        put(DataSource.DATA_SOURCE_STAT, Lists.newArrayList(LogicTable.STAT));
    }};


}

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

    /**
     * 分表对应的分割符
     */
    String SHARDING_SEPARATOR = "_";

    interface DataSource {
        String DATA_SOURCE_HISTORY = "history";
        String DATA_SOURCE_STAT = "stat";
    }

    interface LogicTable {
        String HISTORY = "history_acc";
        String STAT = "stat_acc";
    }

    Map<String, List<String>> DATA_SOURCE_TABLE = new HashMap<String, List<String>>() {{
        put(DataSource.DATA_SOURCE_HISTORY, Lists.newArrayList(LogicTable.HISTORY));
        put(DataSource.DATA_SOURCE_STAT, Lists.newArrayList(LogicTable.STAT));
    }};

    /**
     * 自定义分片策略对应的key
     */
    interface ShardingType {
        /**
         * 分库标识
         */
        String DATABASE_SHARDING_TYPE = "DatabaseHardingType";
        /**
         * 按时间分表，里面会根据传递的参数，处理按年分表，按月分表，按周分表，按天分表。
         */
        String TABLE_SHARDING_TYPE_TIME = "TableShardingTypeTime";
    }

    /**
     * 自定义的分表类型，比如按年分表，按日分表，按天分表，按周分表等等
     */
    enum TableTimeShardingEnum {

        /**
         * 按年分表 YYYY
         */
        YEAR(0),
        /**
         * 按月分表 YYYYMM
         */
        MONTH(1),
        /**
         * 按周分表 YYYYMM_W
         */
        WEEK(2),
        /**
         * 按天分表 YYYYMMDD
         */
        DAY(3);

        int value;

        TableTimeShardingEnum(int value) {
            this.value = value;
        }

        public static TableTimeShardingEnum toEnum(int value) {
            for (TableTimeShardingEnum item : TableTimeShardingEnum.values()) {
                if (item.value == value) {
                    return item;
                }
            }
            return null;
        }

        public static TableTimeShardingEnum toEnum(String value) {
            try {
                return toEnum(Integer.parseInt(value));
            } catch (NumberFormatException ex) {
                return null;
            }
        }
    }


}

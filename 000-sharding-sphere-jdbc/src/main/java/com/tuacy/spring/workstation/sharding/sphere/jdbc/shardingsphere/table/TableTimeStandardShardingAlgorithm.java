package com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.table;

import cn.hutool.core.util.StrUtil;
import com.tuacy.common.utils.LocalDateTimeUtil;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.shardingsphere.ShardingSphereConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 自定义分表 - 按时间分表
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 16:27.
 */
@Slf4j
public class TableTimeStandardShardingAlgorithm implements StandardShardingAlgorithm<String> {

    /**
     * Properties 配置对应的key
     */
    private static final String PROPERTIES_KEY_TYPE = "shardingType";

    /**
     * 配置文件里面配置的自定义参数
     */
    private Properties props = new Properties();

    /**
     * 实现精确分片
     * ps: 字段对应的时间格式，2021-05-23 09:20
     *
     * @param availableTargetNames 所有的可用分片资源集合 -- 对应配置文件里面 actual-data-nodes
     * @param shardingValue        所有的可用分片资源集合
     * @return 分库后指向的数据源名称集合
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<String> shardingValue) {
        ShardingSphereConstants.TableTimeShardingEnum shardingType = getShardingFromProps();
        if (shardingType == null) {
            throw new NullPointerException("根据时间分表，需要制定是按年，按月，按周，按日分表");
        }
        String actualSharding;
        switch (shardingType) {
            case YEAR:
                // 2021-05-23 09:20 -> 2021
                actualSharding = shardingValue.getValue().substring(0, 4);
                break;
            case MONTH:
                // 2021-05-23 09:20 -> 202105
                actualSharding = shardingValue.getValue().substring(0, 7).replace("-", "");
                break;
            case WEEK:
                // 2021-05-23 09:20 -> 2021
                actualSharding = shardingValue.getValue().substring(0, 7).replace("-", "") + ShardingSphereConstants.SHARDING_SEPARATOR + LocalDateTimeUtil.getWeekOfMonth(shardingValue.getValue());
                break;
            case DAY:
                // 2021-05-23 09:20 -> 20210523
                actualSharding = shardingValue.getValue().substring(0, 10).replace("-", "");
                break;
            default:
                throw new NullPointerException("根据时间分表，需要制定是按年，按月，按周，按日分表");
        }
        if (StrUtil.isEmpty(actualSharding)) {
            return shardingValue.getLogicTableName();
        }
        log.info("logicTableName = {}, shardingTable = {}", shardingValue.getLogicTableName(), actualSharding);
        return shardingValue.getLogicTableName() + ShardingSphereConstants.SHARDING_SEPARATOR + actualSharding;
    }

    /**
     * 实现范围分片
     *
     * @param availableTargetNames 所有的可用分片资源集合  -- 对应配置文件里面 actual-data-nodes
     * @param shardingValue        所有的可用分片资源集合
     * @return 分库后指向的数据源名称集合
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<String> shardingValue) {
        return null;
    }

    @Override
    public void init() {
        log.info("自定义分表 - 根据时间字段分表 初始化");
    }

    @Override
    public String getType() {
        return ShardingSphereConstants.ShardingType.TABLE_SHARDING_TYPE_TIME;
    }

    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void setProps(Properties properties) {
        this.props = properties;
    }

    private ShardingSphereConstants.TableTimeShardingEnum getShardingFromProps() {
        if (this.props == null) {
            return null;
        }
        int value = (Integer) this.props.get(PROPERTIES_KEY_TYPE);
        return ShardingSphereConstants.TableTimeShardingEnum.toEnum(value);
    }
}

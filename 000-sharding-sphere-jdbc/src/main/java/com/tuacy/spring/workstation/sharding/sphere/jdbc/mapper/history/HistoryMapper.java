package com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.history;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 历史数据
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:42.
 */
@Mapper
public interface HistoryMapper {

    /**
     * 插入数据
     *
     * @param item 需要插入的item
     * @return 插入条数
     */
    int insertItem(@Param("item") HistoryDO item);

}

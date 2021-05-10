package com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.stat;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.stat.StatDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 统计数据
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 10:43.
 */
@Mapper
public interface StatMapper {

    /**
     * 插入数据
     *
     * @param item 需要插入的item
     * @return 插入条数
     */
    int insertItem(@Param("item") StatDO item);

}

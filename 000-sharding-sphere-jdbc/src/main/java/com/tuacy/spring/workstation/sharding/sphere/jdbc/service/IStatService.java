package com.tuacy.spring.workstation.sharding.sphere.jdbc.service;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.stat.StatDO;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:27.
 */
public interface IStatService {

    /**
     * 插入数据
     * @param item 需要插入的数据
     */
    void insertStat(StatDO item);

}

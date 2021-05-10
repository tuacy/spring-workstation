package com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IStatDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.stat.StatDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.stat.StatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:26.
 */
@Repository
public class StatDaoImpl implements IStatDao {

    private StatMapper statMapper;

    @Autowired
    public void setStatMapper(StatMapper statMapper) {
        this.statMapper = statMapper;
    }


    /**
     * 插入数据
     *
     * @param item 需要插入的数据
     */
    @Override
    public void insertStat(StatDO item) {

    }
}

package com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IHistoryDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.history.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:26.
 */
@Repository
public class HistoryDaoImpl implements IHistoryDao {

    private HistoryMapper historyMapper;

    @Autowired
    public void setHistoryMapper(HistoryMapper historyMapper) {
        this.historyMapper = historyMapper;
    }

    /**
     * 插入数据
     *
     * @param item 需要插入的数据
     */
    @Override
    public void insertHistory(HistoryDO item) {
        historyMapper.insertItem(item);
    }
}

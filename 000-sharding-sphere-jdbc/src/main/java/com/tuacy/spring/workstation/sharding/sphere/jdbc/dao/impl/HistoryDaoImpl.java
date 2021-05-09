package com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IHistoryDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.mapper.history.HistoryMapper;
import org.apache.shardingsphere.api.hint.HintManager;
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
        // Hint分片策略必须要使用 HintManager工具类
        HintManager hintManager = HintManager.getInstance();
        hintManager.addDatabaseShardingValue("t_order", "0");
        hintManager.addTableShardingValue("t_order", "1");
        historyMapper.insertItem(item);
        hintManager.close();
    }
}

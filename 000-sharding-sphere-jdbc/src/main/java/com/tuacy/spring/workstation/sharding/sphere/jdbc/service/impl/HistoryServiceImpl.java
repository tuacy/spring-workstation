package com.tuacy.spring.workstation.sharding.sphere.jdbc.service.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IHistoryDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.service.IHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:27.
 */
@Service
public class HistoryServiceImpl implements IHistoryService {


    private IHistoryDao historyDao;

    @Autowired
    public void setHistoryDao(IHistoryDao historyDao) {
        this.historyDao = historyDao;
    }

    /**
     * 插入数据
     * @param item 需要插入的数据
     */
    @Override
    public void insertHistory(HistoryDO item) {
        historyDao.insertHistory(item);
    }
}

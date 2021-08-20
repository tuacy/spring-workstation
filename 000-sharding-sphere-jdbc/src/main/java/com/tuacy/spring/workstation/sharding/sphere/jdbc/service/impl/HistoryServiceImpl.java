package com.tuacy.spring.workstation.sharding.sphere.jdbc.service.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IHistoryDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.service.IHistoryService;
import org.apache.shardingsphere.infra.hint.HintManager;
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
        // Hint分片策略必须要使用 HintManager工具类
        // 清除掉上一次的规则，否则会报错
        HintManager.clear();
        // HintManager API 工具类实例
        HintManager hintManager = HintManager.getInstance();
        // 直接指定对应具体的数据库
        hintManager.addDatabaseShardingValue("history_acc","stat");
        // 设置表的分片健
//        hintManager.addTableShardingValue("recTime" , "2021");
        historyDao.insertHistory(item);
    }
}

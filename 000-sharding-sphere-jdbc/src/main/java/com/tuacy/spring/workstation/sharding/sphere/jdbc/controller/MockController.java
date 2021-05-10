package com.tuacy.spring.workstation.sharding.sphere.jdbc.controller;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history.HistoryDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.stat.StatDO;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.service.IHistoryService;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.service.IStatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:22.
 */
@RestController
@RequestMapping("/v1/mock")
@Slf4j
public class MockController {

    private IHistoryService historyService;
    private IStatService statService;

    @Autowired
    public void setHistoryService(IHistoryService historyService) {
        this.historyService = historyService;
    }

    @Autowired
    public void setStatService(IStatService statService) {
        this.statService = statService;
    }

    /**
     * 测试函数
     *
     * @return 是否成功
     */
    @RequestMapping(value = "/historyInsert", method = RequestMethod.POST)
    public String historyInsert() {
        HistoryDO item = new HistoryDO();
        item.setPointPkId(Math.abs((int) UUID.randomUUID().getLeastSignificantBits()));
        item.setRecTime("2021-05-07 11:50:00");
        item.setValue(10d);
        historyService.insertHistory(item);
        return "ok";
    }

    /**
     * 测试函数
     *
     * @return 是否成功
     */
    @RequestMapping(value = "/statInsert", method = RequestMethod.POST)
    public String statInsert() {
        StatDO item = new StatDO();
        item.setPointPkId(Math.abs((int) UUID.randomUUID().getLeastSignificantBits()));
        item.setRecTime("2021-05-07 11:50:00");
        item.setValue(10d);
        item.setIncrValue(10d);
        statService.insertStat(item);
        return "ok";
    }
}

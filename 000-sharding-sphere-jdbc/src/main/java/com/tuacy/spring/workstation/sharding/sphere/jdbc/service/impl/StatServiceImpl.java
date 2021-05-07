package com.tuacy.spring.workstation.sharding.sphere.jdbc.service.impl;

import com.tuacy.spring.workstation.sharding.sphere.jdbc.dao.IStatDao;
import com.tuacy.spring.workstation.sharding.sphere.jdbc.service.IStatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:27.
 */
@Service
public class StatServiceImpl implements IStatService {

    private IStatDao statDao;

    @Autowired
    public void setStatDao(IStatDao statDao) {
        this.statDao = statDao;
    }
}

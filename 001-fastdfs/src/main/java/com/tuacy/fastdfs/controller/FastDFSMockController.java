package com.tuacy.fastdfs.controller;

import com.tuacy.common.entity.web.controller.BaseController;
import com.tuacy.fastdfs.component.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wuyx
 * @version 1.0
 * @date 2021/5/23 11:36
 */
@RestController
@RequestMapping("/fdfs")
public class FastDFSMockController extends BaseController {

    private FastDFSClient fastDFSClient;

    @Autowired
    public void setFastDFSClient(FastDFSClient fastDFSClient) {
        this.fastDFSClient = fastDFSClient;
    }
}

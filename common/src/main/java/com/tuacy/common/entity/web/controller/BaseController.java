package com.tuacy.common.entity.web.controller;

import com.google.common.collect.Lists;
import com.tuacy.common.entity.web.response.ResponseResult;

import java.util.List;

/**
 * controller对应的基类，主要是应对一些方法的封装
 *
 * @author wuyx
 * @version 1.0
 * @date 2021/5/23 11:37
 */
public abstract class BaseController {

    protected ResponseResult<Void> setResponseResult() {
        return new ResponseResult<>();
    }

    protected <T> ResponseResult<T> setResponseResult(T data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setData(Lists.newArrayList(data));
        return result;
    }

    protected <T> ResponseResult<T> setResponseResult(List<T> data) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setData(data);
        return result;
    }

}

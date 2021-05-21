package com.tuacy.common.entity.web.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/21 14:18.
 */
@ApiModel(value = "ResponseResult", description = "返回对象基类")
public class ResponseResult<T> implements ResponseEntity {

    @ApiModelProperty(value = "返回结果值 0：成功, 1:参数不正确, 2:JSON参数格式错误, 3:数据库操作失败, 4:用户未授权, 5:服务器忙, 6:用户未登录, 7:其他错误, 8:当保存操作时需要进行再次确认", required = true)
    private int status;
    @ApiModelProperty(value = "返回结果描述", required = true)
    private String msg;
    @ApiModelProperty(value = "返回结果对象", required = true)
    private List<T> data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}

package com.tuacy.common.entity.web.param;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页请求参数基类
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/21 14:00.
 */
@ApiModel(value = "BasePageParam", description = "分页请求参数基类")
public class BasePageParam {

    @ApiModelProperty(value = "页码", example = "1",required = true)
    private int pageNo;
    @ApiModelProperty(value = "页面大小", example = "10",required = true)
    private int pageSize;
    @ApiModelProperty(value = "总记录数", example = "100")
    private long totalCount;
    @ApiModelProperty(value = "排序字段", example = "name")
    private String field;
    @ApiModelProperty(value = "排序类型", example = "asc")
    private String type;
    @ApiModelProperty(value = "搜索关键字", example = "")
    private String searchKey;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public String toString() {
        return "BasePageParam{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", field='" + field + '\'' +
                ", type='" + type + '\'' +
                ", searchKey='" + searchKey + '\'' +
                '}';
    }
}

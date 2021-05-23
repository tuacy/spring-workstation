package com.tuacy.common.entity.web.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 页面返回对象基类
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/21 14:21.
 */
@ApiModel(value = "ResponsePageResult", description = "分页返回对象基类")
public class ResponsePageResult<T> extends ResponseResult<T> {

    @ApiModelProperty(value = "当前页码", required = true)
    private long pageIndex;
    @ApiModelProperty(value = "每页记录数", required = true)
    private long pageSize;
    @ApiModelProperty(value = "总记录数", required = true)
    private long totalCount;
    @ApiModelProperty(value = "总页数", required = true)
    private long totalPage;

    public ResponsePageResult(long pageIndex, long pageSize, long totalCount, long totalPage) {
        super();
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
    }

    public long getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(long pageIndex) {
        this.pageIndex = pageIndex;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "ResponsePageResult{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}

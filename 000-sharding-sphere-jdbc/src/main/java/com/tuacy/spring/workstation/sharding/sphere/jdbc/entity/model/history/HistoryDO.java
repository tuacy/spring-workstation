package com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.history;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:16.
 */
public class HistoryDO {

    /**
     * ACC测点pkId
     */
    private Integer pointPkId;
    /**
     * 记录时间
     */
    private String recTime;
    /**
     * 表底值
     */
    private Double value;

    public Integer getPointPkId() {
        return pointPkId;
    }

    public void setPointPkId(Integer pointPkId) {
        this.pointPkId = pointPkId;
    }

    public String getRecTime() {
        return recTime;
    }

    public void setRecTime(String recTime) {
        this.recTime = recTime;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "AccHistoryOrgDO{" +
                "pointPkId=" + pointPkId +
                ", recTime='" + recTime + '\'' +
                ", value=" + value +
                '}';
    }

}

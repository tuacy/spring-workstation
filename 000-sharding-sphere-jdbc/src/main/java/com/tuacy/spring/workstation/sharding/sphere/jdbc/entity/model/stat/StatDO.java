package com.tuacy.spring.workstation.sharding.sphere.jdbc.entity.model.stat;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/7 11:17.
 */
public class StatDO {

    /**
     * AI/AM测点仪表PkId
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
    /**
     * 增量值
     */
    private Double incrValue;

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

    public Double getIncrValue() {
        return incrValue;
    }

    public void setIncrValue(Double incrValue) {
        this.incrValue = incrValue;
    }

    @Override
    public String toString() {
        return "AccStatDO{" +
                "pointPkId='" + pointPkId + '\'' +
                ", recTime='" + recTime + '\'' +
                ", value=" + value +
                ", incrValue=" + incrValue +
                '}';
    }

}

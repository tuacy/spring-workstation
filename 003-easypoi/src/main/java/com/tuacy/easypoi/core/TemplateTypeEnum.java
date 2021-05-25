package com.tuacy.easypoi.core;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 15:11.
 */
public enum TemplateTypeEnum {

    /**
     * 模板设置的值为null
     */
    CELL_EMPTY(-1),
    /**
     * 单元格显示时间
     */
    CELL_TIME(0),
    /**
     * 单元格显示测点值
     */
    CELL_POINT_VALUE(1),
    /**
     * 单元格显示测点名称
     */
    CELL_POINT_NAME(2),
    /**
     * 单元格显示监控设备对应的名称
     */
    CELL_MONITOR_DEVICE_NAME(3);

    private int type;

    TemplateTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return "TemplateTypeEnum{" +
                "type=" + type +
                '}';
    }
}

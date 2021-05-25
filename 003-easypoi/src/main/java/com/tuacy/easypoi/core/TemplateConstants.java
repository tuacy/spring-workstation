package com.tuacy.easypoi.core;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/25 8:29.
 */
public interface TemplateConstants {

    interface CellTypeStartWith {
        /**
         * 单元格显示时间
         */
        String TIME = "tm";
        /**
         * 单元格显示测点对应的值
         */
        String POINT_VALUE = "pv";
        /**
         * 单元格显示测点对应的名称
         */
        String POINT_NAME = "pn";
        /**
         * 单元格显示监控设备对应的名称
         */
        String MONITOR_DEVICE_NAME_START_WITH = "mdn";
    }

    /**
     * 模板表达式的格式
     * 单元格显示时间               -> {{tm(TemplateTimeEntity对应的json字符串)}}
     * 单元格显示测点值             -> {{pv(TemplatePointValueEntity对应的json字符串)}}
     * 单元格显示测点名称           -> {{pn(TemplatePointNameEntity对应的json字符串)}}
     * 单元格显示监控设备对应的名称  -> {{mdn(TemplateMonitorDeviceNameEntity对应的字符串)}}
     */
    String TEMPLATE_START_WITH = "{{";
    String TEMPLATE_END_WITH = "}}";
    String TEMPLATE_EFFECTIVE_VALUE_START_WITH = "(";
    String TEMPLATE_EFFECTIVE_VALUE_END_WITH = ")";

}

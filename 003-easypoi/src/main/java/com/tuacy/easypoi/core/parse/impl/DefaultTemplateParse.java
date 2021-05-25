package com.tuacy.easypoi.core.parse.impl;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuacy.easypoi.core.TemplateConstants;
import com.tuacy.easypoi.core.TemplateEntity;
import com.tuacy.easypoi.core.TemplateTypeEnum;
import com.tuacy.easypoi.core.parse.ITemplateParse;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 16:53.
 */
@Slf4j
public class DefaultTemplateParse implements ITemplateParse {

    /**
     * JSON转换
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 采用的写法是{{}}代表表达式 -> {{xxx}}是easypoi要求的模板格式
     * 注意模板表达式的格式
     * 显示时间              -> {{tm(TemplateTimeEntity对应的json字符串)}}
     * 显示测点对应值        -> {{pv(TemplatePointValueEntity对应的json字符串)}}
     * 显示测点对应的名称     -> {{pn(TemplatePointNameEntity对应的json字符串)}}
     * 显示监控设备对应的名称 -> {{mdn(TemplateMonitorDeviceNameEntity对应的字符串)}}
     *
     * @param templateStr 模板字符串
     * @return 模板对象
     */
    @Override
    public TemplateEntity parse(String templateStr) {
        if (StrUtil.isEmpty(templateStr)) {
            return null;
        }
        if (!templateStr.startsWith(TemplateConstants.TEMPLATE_START_WITH) || !templateStr.endsWith(TemplateConstants.TEMPLATE_END_WITH)) {
            throw new IllegalArgumentException(String.format("单元格设置的模板不合法，模板必须以{{开头，以}}结尾，错误的模板：%s", templateStr));
        }
        // 去掉 {{}}
        String temp = templateStr.substring(TemplateConstants.TEMPLATE_START_WITH.length(), templateStr.length() - TemplateConstants.TEMPLATE_END_WITH.length());
        if (StrUtil.isEmpty(temp)) {
            return new TemplateEntity(TemplateTypeEnum.CELL_EMPTY, null);
        }
        TemplateTypeEnum templateTypeEnum = null;
        Object templateEffective = null;
        try {
            if (temp.startsWith(TemplateConstants.CellTypeStartWith.TIME)) {
                templateTypeEnum = TemplateTypeEnum.CELL_TIME;
                // 去掉前后 ()
                temp = temp.substring(TemplateConstants.CellTypeStartWith.TIME.length());
                // 有效值一定要以(开头，)结尾
                if (StrUtil.isEmpty(temp) || !templateStr.startsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_START_WITH) || !templateStr.endsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_END_WITH)){
                    temp = temp.substring(1, temp.length() - 1);
                    templateEffective = OBJECT_MAPPER.readValue(temp, TemplateEntity.TemplateTimeEntity.class);
                }
            } else if (temp.startsWith(TemplateConstants.CellTypeStartWith.POINT_VALUE)) {
                templateTypeEnum = TemplateTypeEnum.CELL_POINT_VALUE;
                temp = temp.substring(TemplateConstants.CellTypeStartWith.POINT_VALUE.length());
                // 有效值一定要以(开头，)结尾
                if (StrUtil.isEmpty(temp) || !templateStr.startsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_START_WITH) || !templateStr.endsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_END_WITH)){
                    temp = temp.substring(1, temp.length() - 1);
                    templateEffective = OBJECT_MAPPER.readValue(temp, TemplateEntity.TemplatePointValueEntity.class);
                }
            } else if (temp.startsWith(TemplateConstants.CellTypeStartWith.POINT_NAME)) {
                templateTypeEnum = TemplateTypeEnum.CELL_POINT_NAME;
                temp = temp.substring(TemplateConstants.CellTypeStartWith.POINT_NAME.length());
                // 有效值一定要以(开头，)结尾
                if (StrUtil.isEmpty(temp) || !templateStr.startsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_START_WITH) || !templateStr.endsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_END_WITH)){
                    temp = temp.substring(1, temp.length() - 1);
                    templateEffective = OBJECT_MAPPER.readValue(temp, TemplateEntity.TemplatePointNameEntity.class);
                }
            } else if (temp.startsWith(TemplateConstants.CellTypeStartWith.MONITOR_DEVICE_NAME_START_WITH)) {
                templateTypeEnum = TemplateTypeEnum.CELL_MONITOR_DEVICE_NAME;
                temp = temp.substring(TemplateConstants.CellTypeStartWith.MONITOR_DEVICE_NAME_START_WITH.length());
                // 有效值一定要以(开头，)结尾
                if (StrUtil.isEmpty(temp) || !templateStr.startsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_START_WITH) || !templateStr.endsWith(TemplateConstants.TEMPLATE_EFFECTIVE_VALUE_END_WITH)){
                    temp = temp.substring(1, temp.length() - 1);
                    templateEffective = OBJECT_MAPPER.readValue(temp, TemplateEntity.TemplateMonitorDeviceNameEntity.class);
                }
            }
        } catch (JsonProcessingException ex) {
            log.error("解析模板表达式异常", ex);
        }

        return new TemplateEntity(templateTypeEnum, templateEffective);
    }

}

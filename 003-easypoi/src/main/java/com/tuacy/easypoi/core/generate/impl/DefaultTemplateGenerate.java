package com.tuacy.easypoi.core.generate.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuacy.easypoi.core.TemplateConstants;
import com.tuacy.easypoi.core.TemplateEntity;
import com.tuacy.easypoi.core.TemplateTypeEnum;
import com.tuacy.easypoi.core.generate.ITemplateGenerate;
import lombok.extern.slf4j.Slf4j;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/24 16:53.
 */
@Slf4j
public class DefaultTemplateGenerate implements ITemplateGenerate {

    /**
     * JSON转换
     */
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static final String TEMPLATE_STR_FORMATTER = "{{%s(%s)}}";

    @Override
    public String parse(TemplateEntity templateEntity) {
        if (templateEntity == null || templateEntity.getType() == null || templateEntity.getType() == TemplateTypeEnum.CELL_EMPTY) {
            return null;
        }
        if (templateEntity.getObject() == null) {
            return null;
        }
        try {
            switch (templateEntity.getType()) {
                case CELL_TIME:
                    return String.format(TEMPLATE_STR_FORMATTER, TemplateConstants.CellTypeStartWith.TIME, OBJECT_MAPPER.writeValueAsString(templateEntity.getObject()));
                case CELL_POINT_NAME:
                    return String.format(TEMPLATE_STR_FORMATTER, TemplateConstants.CellTypeStartWith.POINT_NAME, OBJECT_MAPPER.writeValueAsString(templateEntity.getObject()));
                case CELL_POINT_VALUE:
                    return String.format(TEMPLATE_STR_FORMATTER, TemplateConstants.CellTypeStartWith.POINT_VALUE, OBJECT_MAPPER.writeValueAsString(templateEntity.getObject()));
                case CELL_MONITOR_DEVICE_NAME:
                    return String.format(TEMPLATE_STR_FORMATTER, TemplateConstants.CellTypeStartWith.MONITOR_DEVICE_NAME_START_WITH, OBJECT_MAPPER.writeValueAsString(templateEntity.getObject()));
                default:
            }
        } catch (Exception ex) {
            log.error("json转换异常", ex);
        }

        return null;
    }


}

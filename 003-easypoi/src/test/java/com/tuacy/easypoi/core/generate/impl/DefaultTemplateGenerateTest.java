package com.tuacy.easypoi.core.generate.impl;

import com.tuacy.easypoi.core.TemplateEntity;
import com.tuacy.easypoi.core.TemplateTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/25 16:14.
 */
@SpringBootTest
@Slf4j
class DefaultTemplateGenerateTest {

    @Test
    public void testTemplateGenerate() {
        DefaultTemplateGenerate templateGenerate = new DefaultTemplateGenerate();

        TemplateEntity.TemplatePointValueEntity pointValueEntity = new TemplateEntity.TemplatePointValueEntity();
        pointValueEntity.setIoServerId("1001");
        pointValueEntity.setPointId("5000001");
        pointValueEntity.setStartTime("2021-05-25 13:00");
        pointValueEntity.setEndTime("2021-05-25 13:00");
        pointValueEntity.setValueType(1);
        TemplateEntity entity = new TemplateEntity(TemplateTypeEnum.CELL_POINT_VALUE, pointValueEntity);

        System.out.println(templateGenerate.parse(entity));
        System.out.println("aaaaaaaaaaaaaaaaaa");
    }

}

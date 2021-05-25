package com.tuacy.easypoi.core;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.hutool.core.collection.CollectionUtil;
import com.tuacy.easypoi.core.entity.TemplateCell;
import com.tuacy.easypoi.core.parse.impl.DefaultTemplateParse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/25 16:22.
 */
@SpringBootTest
@Slf4j
public class ExcelGenerate {

    private DefaultTemplateParse templateParse = new DefaultTemplateParse();

    @Test
    public void excel() throws Exception {

        String excelTemplateFilePath = "temp/tmTest.xlsx";

        final List<TemplateCell> templateCells = TemplateUtils.loadTemplateCell(new File(excelTemplateFilePath), s -> s.startsWith("{{") && s.endsWith("}}"));

        if (!CollectionUtil.isEmpty(templateCells)) {
            List<TemplateEntity> templateEntityList = Lists.newArrayList();
            Map<String, Object> map = new HashMap<>();
            for (int index = 0; index < templateCells.size(); index++) {
                map.put(templateCells.get(index).getEasyPoiTemplateKey(), new Random().nextInt(1000) / 100.0f);
                templateEntityList.add(templateParse.parse(templateCells.get(index).getTemplateValue()));
            }

            TemplateExportParams params = new TemplateExportParams(excelTemplateFilePath);
            Workbook workbook = ExcelExportUtil.exportExcel(params, map);
            File savefile = new File("D:/home/excel/");
            if (!savefile.exists()) {
                savefile.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream("D:/home/excel/pointMonth.xlsx");
            workbook.write(fos);
            fos.close();

        }
    }


}

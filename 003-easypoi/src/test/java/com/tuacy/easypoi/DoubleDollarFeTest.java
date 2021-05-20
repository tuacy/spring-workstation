package com.tuacy.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/19 15:19.
 */
@SpringBootTest
public class DoubleDollarFeTest {

    @Test
    public void test() throws Exception {
        TemplateExportParams params = new TemplateExportParams(
                "temp/manyfe.xlsx");
        Map<String, Object> map     = new HashMap<String, Object>();
        List<Map<String, Object>> dldayuList = new ArrayList<Map<String, Object>>();
        List<Map<String, Object>> dlxiaoyuList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 100; i++) {
            Map<String, Object> testMap = new HashMap<String, Object>();

            testMap.put("mdd", "080101" + i);
            testMap.put("fhzlS", "大学" + i + "班");
            testMap.put("sjzcS", "30" + i);
            testMap.put("dgjcbzfSJ", "40" + i);
            dlxiaoyuList.add(testMap);
            dldayuList.add(testMap);
        }
        map.put("dlxiaoyuList", dlxiaoyuList);
        map.put("dldayuList", dldayuList);
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/home/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/home/excel/DoubleDollarFeTest.test.xlsx");
        workbook.write(fos);
        fos.close();
    }

}

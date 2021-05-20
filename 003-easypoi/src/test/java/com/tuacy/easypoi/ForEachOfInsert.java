package com.tuacy.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/19 15:22.
 */
public class ForEachOfInsert {

    @Test
    public void test() throws Exception {
        TemplateExportParams params = new TemplateExportParams("temp/simplateTemplage.xlsx");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("point:01:01:value", "10");
        map.put("point:02:01:value", "11");
        map.put("point:03:01:value", "12");
        map.put("point:04:01:value", "13");
        map.put("point:01:02:value", "14");
        map.put("point:02:02:value", "15");
        map.put("point:03:02:value", "16");
        map.put("point:04:02:value", "17");
        map.put("point:01:03:value", "18");
        map.put("point:02:03:value", "19");
        map.put("point:03:03:value", "20");
        map.put("point:04:03:value", "21");
        map.put("point:01:04:value", "22");
        map.put("point:02:04:value", "23");
        map.put("point:03:04:value", "24");
        map.put("point:04:04:value", "25");
        map.put("point:01:05:value", "26");
        map.put("point:02:05:value", "27");
        map.put("point:03:05:value", "28");
        map.put("point:04:05:value", "29");
        //本来导出是专业那个
        Workbook workbook = ExcelExportUtil.exportExcel(params, map);
        File savefile = new File("D:/home/excel/");
        if (!savefile.exists()) {
            savefile.mkdirs();
        }
        FileOutputStream fos = new FileOutputStream("D:/home/excel/simplateTemplage.xlsx");
        workbook.write(fos);
        fos.close();
    }

    @Test
    public void map() {
        ImportParams params = new ImportParams();
        params.setKeyMark(":");
        ExcelImportResult<Map> result = ExcelImportUtil.importExcelMore(new File("temp/simplateTemplage.xlsx"), Map.class, params);
        for (int i = 0; i < result.getList().size(); i++) {
            System.out.println(result.getList().get(i));
        }
        System.out.println(result.getMap());
    }

}

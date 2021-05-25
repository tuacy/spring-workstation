package com.tuacy.easypoi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;
import cn.afterturn.easypoi.excel.entity.result.ExcelImportResult;
import com.tuacy.easypoi.core.TemplateUtils;
import com.tuacy.easypoi.core.entity.TemplateCell;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/19 14:08.
 */

@SpringBootTest
@Slf4j
public class MockTest {

    @Test
    public void importKeyValue() {
        try {
            ImportParams params = new ImportParams();
            params.setKeyMark(":");
            ExcelImportResult<Map> result = ExcelImportUtil.importExcelMore(new File("temp/simplateTemplage.xlsx"), Map.class, params);
            for (int i = 0; i < result.getList().size(); i++) {
                System.out.println(result.getList().get(i));
            }
            System.out.println(result.getMap());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    @Test
    public void templateTest() throws Exception {
        TemplateExportParams params = new TemplateExportParams("temp/simplateTemplage.xlsx",1);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("year", "2019");
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
    public void aaa() {
        final List<TemplateCell> templateCells = TemplateUtils.loadTemplateCell(new File("temp/simplateTemplage.xlsx"), new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return true;
            }
        });

//        FileInputStream in = null;
//        ByteArrayOutputStream baos   = new ByteArrayOutputStream();
//        try {
//            in = new FileInputStream(new File("temp/simplateTemplage.xlsx"));
//            byte[] buffer = new byte[1024];
//            int    len;
//            while ((len = in.read(buffer)) > -1) {
//                baos.write(buffer, 0, len);
//            }
//            baos.flush();
//            InputStream userIs = new ByteArrayInputStream(baos.toByteArray());
//            Workbook book = WorkbookFactory.create(userIs);
//
//            book.getSheetAt(0).getRow(2).createCell(8).setCellValue("insert");
//
//            File savefile = new File("D:/home/excel/");
//            if (!savefile.exists()) {
//                savefile.mkdirs();
//            }
//            FileOutputStream fos = new FileOutputStream("D:/home/excel/aaaa.xlsx");
//            book.write(fos);
//            fos.close();
//
//        } catch (ExcelImportException e) {
//            throw new ExcelImportException(e.getType(), e);
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//            throw new ExcelImportException(e.getMessage(), e);
//        } finally {
//            IOUtils.closeQuietly(in);
//            IOUtils.closeQuietly(baos);
//        }
//
//
//        System.out.println("aaaaaaaaaaaaaaa");
    }

    @Test
    public void aaaa() {
        ImportParams params = new ImportParams();
        //params.setTitleRows(1);
        params.setHeadRows(0);
        List<String> list = ExcelImportUtil.importExcel(
                new File("temp/simplateTemplage.xlsx"),
                String.class, params);
        System.out.println("aaaaaaaaaaaaaaa");
    }

}

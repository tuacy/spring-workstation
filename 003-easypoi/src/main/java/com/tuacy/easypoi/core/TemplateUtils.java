package com.tuacy.easypoi.core;

import cn.afterturn.easypoi.exception.excel.ExcelImportException;
import cn.afterturn.easypoi.util.PoiCellUtil;
import cn.hutool.core.util.StrUtil;
import com.tuacy.easypoi.core.entity.TemplateCell;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.List;
import java.util.function.Predicate;

/**
 * 模板相关的一些工具类
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/25 9:39.
 */
@Slf4j
public class TemplateUtils {

    private TemplateUtils() {
    }

    /**
     * 加载excel文件里面所有的单元格对应的模板表达式
     *
     * @param file      excel文件
     * @param predicate 模板表达式的匹配项
     * @return 所有单元格对应的模板表达式列表
     */
    public static List<TemplateCell> loadTemplateCell(File file, Predicate<String> predicate) {
        FileInputStream in = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            InputStream userIs = new ByteArrayInputStream(baos.toByteArray());
            Workbook book = WorkbookFactory.create(userIs);
            return loadTemplateCell(book, predicate);
        } catch (ExcelImportException e) {
            throw new ExcelImportException(e.getType(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExcelImportException(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(baos);
        }
    }

    /**
     * 加载excel文件里面所有的单元格对应的模板表达式
     *
     * @param file          excel文件
     * @param templateRegex 模板匹配对应的正则表达式
     * @return 所有单元格对应的模板表达式列表
     */
    public static List<TemplateCell> loadTemplateCell(File file, String templateRegex) {
        FileInputStream in = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            in = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            InputStream userIs = new ByteArrayInputStream(baos.toByteArray());
            Workbook book = WorkbookFactory.create(userIs);
            return loadTemplateCell(book, templateRegex);
        } catch (ExcelImportException e) {
            throw new ExcelImportException(e.getType(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new ExcelImportException(e.getMessage(), e);
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(baos);
        }
    }

    /**
     * 加载excel文件里面所有的单元格对应的模板表达式
     *
     * @param workbook  excel文件对应的Workbook
     * @param predicate 模板表达式的匹配项
     * @return 所有单元格对应的模板表达式列表
     */
    public static List<TemplateCell> loadTemplateCell(Workbook workbook, Predicate<String> predicate) {
        if (workbook == null) {
            return null;
        }
        List<TemplateCell> retList = Lists.newArrayList();
        final int sheetCount = workbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetCount; sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(0);
            int sheetMergeCount = sheet.getNumMergedRegions();
            List<CellRangeAddress> cellRangeAddressList = Lists.newArrayList();

            for (int i = 0; i < sheetMergeCount; i++) {
                cellRangeAddressList.add(sheet.getMergedRegion(i));
            }
            //遍历该工作薄中所有的行
            for (Row row : sheet) {
                //遍历一行中的所有的单元格
                for (Cell cell : row) {
                    // 你需要实现功能的代码
                    String cellText = PoiCellUtil.getCellValue(cell);
                    if (StrUtil.isNotEmpty(cellText)) {
                        if (predicate.test(cellText)) {
                            final CellRangeAddress cellRangeAddress = getCellRangeAddress(cellRangeAddressList, cell.getRowIndex(), cell.getColumnIndex());
                            if (cellRangeAddress == null) {
                                retList.add(new TemplateCell(sheetIndex, cell.getColumnIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex(), cell.getRowIndex(), cell.getRowIndex(), cellText));
                            } else {
                                retList.add(new TemplateCell(sheetIndex, cell.getColumnIndex(), cell.getRowIndex(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellText));
                            }

                        }
                    }
                }
            }
        }
        return retList;
    }

    /**
     * 加载excel文件里面所有的单元格对应的模板表达式
     *
     * @param workbook      excel文件对应的Workbook
     * @param templateRegex 模板匹配对应的正则表达式
     * @return 所有单元格对应的模板表达式列表
     */
    public static List<TemplateCell> loadTemplateCell(Workbook workbook, String templateRegex) {
        if (workbook == null) {
            return null;
        }
        List<TemplateCell> retList = Lists.newArrayList();
        final int sheetCount = workbook.getNumberOfSheets();
        for (int sheetIndex = 0; sheetIndex < sheetCount; sheetIndex++) {
            Sheet sheet = workbook.getSheetAt(0);
            int sheetMergeCount = sheet.getNumMergedRegions();
            List<CellRangeAddress> cellRangeAddressList = Lists.newArrayList();

            for (int i = 0; i < sheetMergeCount; i++) {
                cellRangeAddressList.add(sheet.getMergedRegion(i));
            }
            //遍历该工作薄中所有的行
            for (Row row : sheet) {
                //遍历一行中的所有的单元格
                for (Cell cell : row) {
                    // 你需要实现功能的代码
                    String cellText = PoiCellUtil.getCellValue(cell);
                    if (StrUtil.isNotEmpty(cellText)) {
                        if (StrUtil.isEmpty(templateRegex) || cellText.matches(templateRegex)) {
                            final CellRangeAddress cellRangeAddress = getCellRangeAddress(cellRangeAddressList, cell.getRowIndex(), cell.getColumnIndex());
                            if (cellRangeAddress == null) {
                                retList.add(new TemplateCell(sheetIndex, cell.getColumnIndex(), cell.getRowIndex(), cell.getColumnIndex(), cell.getColumnIndex(), cell.getRowIndex(), cell.getRowIndex(), cellText));
                            } else {
                                retList.add(new TemplateCell(sheetIndex, cell.getColumnIndex(), cell.getRowIndex(), cellRangeAddress.getFirstColumn(), cellRangeAddress.getLastColumn(), cellRangeAddress.getFirstRow(), cellRangeAddress.getLastRow(), cellText));
                            }

                        }
                    }
                }
            }
        }
        return retList;
    }

    /**
     * 获取合并的单元格信息
     *
     * @param sheet  sheet
     * @param row    行
     * @param column 列
     * @return 合并单元格信息
     */
    private static CellRangeAddress getCellRangeAddress(Sheet sheet, int row, int column) {
        int sheetMergeCount = sheet.getNumMergedRegions();

        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            int firstColumn = ca.getFirstColumn();
            int lastColumn = ca.getLastColumn();
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {

                    return ca;
                }
            }
        }

        return null;
    }

    /**
     * 获取合并的单元格信息
     *
     * @param cellRangeAddressList 合并的单元格列表
     * @param row                  行
     * @param column               列
     * @return 合并单元格信息
     */
    private static CellRangeAddress getCellRangeAddress(List<CellRangeAddress> cellRangeAddressList, int row, int column) {
        if (CollectionUtils.isEmpty(cellRangeAddressList)) {
            return null;
        }
        for (CellRangeAddress addresses : cellRangeAddressList) {
            int firstColumn = addresses.getFirstColumn();
            int lastColumn = addresses.getLastColumn();
            int firstRow = addresses.getFirstRow();
            int lastRow = addresses.getLastRow();

            if (row >= firstRow && row <= lastRow) {
                if (column >= firstColumn && column <= lastColumn) {

                    return addresses;
                }
            }
        }
        return null;
    }

}

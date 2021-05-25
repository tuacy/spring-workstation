package com.tuacy.easypoi.core.entity;

import com.tuacy.easypoi.core.TemplateConstants;

/**
 * 模板对应的单元格实例
 *
 * @version 1.0
 * @author: tuacy.
 * @date: 2021/5/20 10:22.
 */
public class TemplateCell {

    private int sheetIndex;
    private int column;
    private int row;
    private int firstColumn;
    private int lastColumn;
    private int firstRow;
    private int lastRow;
    private String templateValue;

    public TemplateCell() {

    }

    public TemplateCell(int sheetIndex, int column, int row, int firstColumn, int lastColumn, int firstRow, int lastRow, String templateValue) {
        this.sheetIndex = sheetIndex;
        this.column = column;
        this.row = row;
        this.firstColumn = firstColumn;
        this.lastColumn = lastColumn;
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.templateValue = templateValue;
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getFirstColumn() {
        return firstColumn;
    }

    public void setFirstColumn(int firstColumn) {
        this.firstColumn = firstColumn;
    }

    public int getLastColumn() {
        return lastColumn;
    }

    public void setLastColumn(int lastColumn) {
        this.lastColumn = lastColumn;
    }

    public int getFirstRow() {
        return firstRow;
    }

    public void setFirstRow(int firstRow) {
        this.firstRow = firstRow;
    }

    public int getLastRow() {
        return lastRow;
    }

    public void setLastRow(int lastRow) {
        this.lastRow = lastRow;
    }

    public String getTemplateValue() {
        return templateValue;
    }

    public void setTemplateValue(String templateValue) {
        this.templateValue = templateValue;
    }

    public String getEasyPoiTemplateKey () {
        return templateValue.substring(TemplateConstants.TEMPLATE_START_WITH.length(), templateValue.length() - TemplateConstants.TEMPLATE_END_WITH.length());
    }

    @Override
    public String toString() {
        return "TemplateCell{" +
                "sheetIndex=" + sheetIndex +
                ", column=" + column +
                ", row=" + row +
                ", firstColumn=" + firstColumn +
                ", lastColumn=" + lastColumn +
                ", firstRow=" + firstRow +
                ", lastRow=" + lastRow +
                ", templateValue='" + templateValue + '\'' +
                '}';
    }
}

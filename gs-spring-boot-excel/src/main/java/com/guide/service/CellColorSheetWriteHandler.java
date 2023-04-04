//package com.guide.service;
//
//
//
//
//import com.alibaba.excel.metadata.CellData;
//import com.alibaba.excel.metadata.Head;
//import com.alibaba.excel.util.StyleUtil;
//import com.alibaba.excel.write.handler.CellWriteHandler;
//import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
//import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
//import com.alibaba.excel.write.metadata.style.WriteCellStyle;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//
//import java.awt.Color;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
//import com.alibaba.excel.metadata.CellData;
//import com.alibaba.excel.metadata.Head;
//import com.alibaba.excel.util.StyleUtil;
//import com.alibaba.excel.write.handler.CellWriteHandler;
//import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
//import com.alibaba.excel.write.metadata.holder.WriteTableHolder;
//import com.alibaba.excel.write.metadata.style.WriteCellStyle;
//import org.apache.commons.lang3.StringUtils;
//import org.apache.poi.ss.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFCellStyle;
//import org.apache.poi.xssf.usermodel.XSSFColor;
//import org.apache.poi.xssf.usermodel.XSSFFont;
//
//import java.awt.Color;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//
///**
// * CellColorSheetWriteHandler
// *
// * @author TomLuo
// * @date 2023年03月20日 6:30
// */
//public class CellColorSheetWriteHandler implements CellWriteHandler
//{
//    /**
//     * 多行表头行号
//     */
//    private int headRow;
//
//    /**
//     * 字体
//     */
//    private ExportTable.ExportColumn.Font columnFont = new ExportTable.ExportColumn.Font();
//
//    private static volatile XSSFCellStyle cellStyle = null;
//
//    public static XSSFCellStyle getCellStyle(Workbook workbook, WriteCellStyle contentWriteCellStyle) {
//        if(cellStyle == null) {
//            synchronized (XSSFCellStyle.class) {
//                if(cellStyle == null) {
//                    cellStyle =(XSSFCellStyle) StyleUtil.buildHeadCellStyle(workbook, contentWriteCellStyle);
//                }
//            }
//        }
//        return cellStyle;
//    }
//
//    /**
//     * 字体
//     * Map<Integer, ExportTable.ExportColumn.Font> 当前列的字段样式
//     * Map<Integer, List<Map<...>>> 当前行包含那几列需要设置样式
//     * String head：表头；
//     * String cell：内容；
//     */
//    private Map<String, Map<Integer, List<Map<Integer, ExportTable.ExportColumn.Font>>>> map;
//
//    /**
//     * 有参构造
//     */
//    public CellColorSheetWriteHandler(Map<String, Map<Integer, List<Map<Integer, ExportTable.ExportColumn.Font>>>> map, int headRow) {
//        this.map = map;
//        this.headRow = headRow;
//    }
//
//    /**
//     * 在单元上的所有操作完成后调用
//     */
//    @Override
//    public void afterCellDispose(WriteSheetHolder writeSheetHolder, WriteTableHolder writeTableHolder, List<CellData> cellDataList, Cell cell, Head head, Integer relativeRowIndex, Boolean isHead) {
//        // 当前行的第column列
//        int column = cell.getColumnIndex();
//        // 当前第row行
//        int row = cell.getRowIndex();
//        AtomicInteger fixNum = new AtomicInteger();
//        // 处理行，表头
//        if (headRow > row && map.containsKey("head")){
//            Map<Integer, List<Map<Integer, ExportTable.ExportColumn.Font>>> fonts = map.get("head");
//            fonts.get(row).forEach(e->{
//                e.entrySet().forEach(ele -> {
//                    // 获取冻结字段
//                    if (null != ele.getValue().getFixed() && !StringUtils.isEmpty(ele.getValue().getFixed())) {
//                        fixNum.getAndIncrement();
//                    }
//                    // 字段隐藏
//                    if(!ele.getValue().isShow()){
//                        writeSheetHolder.getSheet().setColumnHidden(ele.getKey(), true);
//                    }
//                });
//            });
//            if (fixNum.get() > 0 && row == 0) {
//                writeSheetHolder.getSheet().createFreezePane(fixNum.get(), headRow, fixNum.get(), headRow);
//            }else{
//                writeSheetHolder.getSheet().createFreezePane(0, headRow, 0, headRow);
//            }
//            setStyle(fonts, row, column, cell, writeSheetHolder, head);
//        }
//        // 处理内容
//        if (headRow <= row && map.containsKey("cell") && !map.containsKey("cellStyle")) {
//            Map<Integer, List<Map<Integer, ExportTable.ExportColumn.Font>>> fonts = map.get("cell");
//            setStyle(fonts, -1, column, cell, writeSheetHolder, head);
//        }
//    }
//
//    private void setStyle(Map<Integer, List<Map<Integer, ExportTable.ExportColumn.Font>>> fonts, int row, int column, Cell cell, WriteSheetHolder writeSheetHolder, Head head){
//        fonts.get(row).forEach(e->{
//            if (e.containsKey(column)){
//                // 根据单元格获取workbook
//                Workbook workbook = cell.getSheet().getWorkbook();
//                //设置列宽
//                if(null != e.get(column).getWidth() && !e.get(column).getWidth().isEmpty()) {
//                    writeSheetHolder.getSheet().setColumnWidth(head.getColumnIndex(), Integer.parseInt(e.get(column).getWidth()) * 20);
//                }else{
//                    writeSheetHolder.getSheet().setColumnWidth(head.getColumnIndex(),2000);
//                }
//                // 单元格策略
//                WriteCellStyle contentWriteCellStyle = new WriteCellStyle();
//                // 设置垂直居中为居中对齐
//                contentWriteCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//                // 设置左右对齐方式
//                if(null != e.get(column).getAlign() && !e.get(column).getAlign().isEmpty()) {
//                    contentWriteCellStyle.setHorizontalAlignment(getHorizontalAlignment(e.get(column).getAlign()));
//                }else{
//                    contentWriteCellStyle.setHorizontalAlignment(HorizontalAlignment.LEFT);
//                }
//                if (!e.get(column).equal(columnFont) || column == 0){
//                    /**
//                     * Prevent the creation of a large number of objects
//                     * Defects of the EasyExcel tool(巨坑，简直脱发神器）
//                     */
//                    cellStyle = (XSSFCellStyle) StyleUtil.buildHeadCellStyle(workbook, contentWriteCellStyle);
//                    // 设置单元格背景颜色
//                    if(null != e.get(column).getBackground() && !e.get(column).getBackground().isEmpty()) {
//                        cellStyle.setFillForegroundColor(new XSSFColor(hex2Color(e.get(column).getBackground())));
//                    }else{
//                        if(cell.getRowIndex() >= headRow)
//                            cellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
//                    }
//
//                    // 创建字体实例
//                    Font font = workbook.createFont();
//                    // 设置字体是否加粗
//                    if(null != e.get(column).getFontWeight() && !e.get(column).getFontWeight().isEmpty())
//                        font.setBold(getBold(e.get(column).getFontWeight()));
//                    // 设置字体和大小
//                    if(null != e.get(column).getFontFamily() && !e.get(column).getFontFamily().isEmpty())
//                        font.setFontName(e.get(column).getFontFamily());
//                    if(0 != e.get(column).getFontSize())
//                        font.setFontHeightInPoints((short) e.get(column).getFontSize());
//                    XSSFFont xssfFont = (XSSFFont)font;
//                    //设置字体颜色
//                    if(null != e.get(column).getColor() && !e.get(column).getColor().isEmpty())
//                        xssfFont.setColor(new XSSFColor(hex2Color(e.get(column).getColor())));
//                    cellStyle.setFont(xssfFont);
//                    // 记录上一个样式
//                    columnFont = e.get(column);
//                }
//
//                // 设置当前行第column列的样式
//                cell.getRow().getCell(column).setCellStyle(cellStyle);
//                // 设置行高
//                cell.getRow().setHeight((short) 400);
//            }
//        });
//    }
//}
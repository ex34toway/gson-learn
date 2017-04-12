package net.jxls;

import autovalue.shaded.org.apache.commons.lang.StringUtils;
import net.sf.jxls.util.Util;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

import java.math.BigDecimal;

/**
 * Created by liliang on 2017/4/12.
 */
public class ExcelHelper {

    /**
     * 向下 Copy rows 行,样式参考 startRow所在行
     * @param sheet
     * @param startRow
     * @param rows
     * @return
     */
    public static void insertRow(Sheet sheet, int startRow,int rows){
        sheet.shiftRows(startRow + 1, sheet.getLastRowNum(), rows,true,false);
        Row sourceRow = sheet.getRow(startRow);//均以开始行为源

        for (int i = 0; i < rows; i++) {
            Row targetRow = null;
            targetRow = sheet.createRow(++startRow);
            Util.copyRow(sheet, sourceRow, targetRow);
        }
    }

    /**
     *
     * @param sheet
     * @param cellRef
     * @param value
     * @return
     */
    public static Cell setCellByCellRef (Sheet sheet,String cellRef,BigDecimal value){
        Cell cell = getCellByCellRef(sheet,cellRef);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        if(value != null){
            cell.setCellValue(String.valueOf(value));
        }
        return cell;
    }

    public static Cell getCellByCellRef(Sheet sheet,String cellRef){
        CellRangeAddress cellRangeAddress = CellRangeAddress.valueOf(cellRef);
        Row row = sheet.getRow(cellRangeAddress.getFirstRow());
        Cell cell = row.getCell(cellRangeAddress.getFirstColumn());
        return cell;
    }
    /**
     * getCell by cell ref,此方法认为该Row一定存在 ！！！
     * @param cellRef
     * @return
     */
    public static Cell setCellByCellRef (Sheet sheet,String cellRef,String value) {
        Cell cell = getCellByCellRef(sheet,cellRef);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        if(StringUtils.isNotBlank(value)){
            cell.setCellValue(value);//默认String
        }
        return cell;
    }

    /**
     * getCell by cell ref,此方法认为该Row一定存在 ！！！
     * @param cellRef
     * @return
     */
    public static Cell setCellByCellRef (Sheet sheet,String cellRef,Integer value){
        Cell cell = getCellByCellRef(sheet,cellRef);
        cell.setCellType(Cell.CELL_TYPE_NUMERIC);
        if(value != null){
            cell.setCellValue(String.valueOf(value));
        }
        return cell;
    }

    public static void setCellValue(Cell cell, String value) {
        if (null != cell && null != value)
            cell.setCellValue(value);
    }

    public static void setCellValue(Cell cell, Integer value) {
        if (null != cell && null != value)
            cell.setCellValue(value);
    }

    public static void setCellValue(Cell cell, BigDecimal value) {
        if (null != cell && null != value)
            cell.setCellValue(String.valueOf(value));
    }
}

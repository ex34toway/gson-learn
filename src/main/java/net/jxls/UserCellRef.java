package net.jxls;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.jxls.common.CellRef;

/**
 * Created by liliang on 2017/4/12.
 */
public class UserCellRef {

    private Sheet sheet;

    private Row curRow;

    private Cell cell;

    int colNum;

    public UserCellRef(Sheet sheet,CellRef cellRef){
        colNum = cellRef.getCol();
        curRow = sheet.getRow(cellRef.getRow());
    }

    /**
     * 找到下一个Cell
     * @return
     */
    public UserCellRef nextCell(){
        colNum++;
        Cell cell = null;
        return this;
    }
}

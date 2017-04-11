package com.demo.jxls.poi;

import org.jxls.command.CellDataUpdater;
import org.jxls.common.CellData;
import org.jxls.common.CellRef;
import org.jxls.common.Context;

/**
 * Created by liliang on 2017/4/11.
 */
public class UpdateCellMergeCellUpdater implements CellDataUpdater {

    @Override
    public void updateCellData(CellData cellData, CellRef targetCell, Context context) {
        String comment = cellData.getCellComment();
        targetCell.getCol();
    }
}

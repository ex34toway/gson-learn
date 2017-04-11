package com.demo.jxls.poi;

import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.common.AreaListener;
import org.jxls.common.CellRef;
import org.jxls.common.Context;

import java.util.Map;

/**
 * Created by liliang on 2017/4/11.
 */
public class MergeHeaderColAreaListener implements AreaListener {

    private CellRangeAddress region;

    public MergeHeaderColAreaListener(CellRangeAddress region)
    {
        this.region = region;
    }

    @Override
    public void beforeApplyAtCell(CellRef cellRef, Context context) {
    }

    @Override
    public void afterApplyAtCell(CellRef cellRef, Context context) {
    }

    @Override
    public void beforeTransformCell(CellRef srcCell, CellRef targetCell, Context context) {
    }

    @Override
    public void afterTransformCell(CellRef srcCell, CellRef targetCell, Context context) {
        Context.Config config = context.getConfig();
        Map<String, String> stringStringMap = config.getCellStyleMap();
        targetCell.getFormattedSheetName();
    }
}

package com.demo.net.jxls;

import static net.jxls.ExcelHelper.*;

import autovalue.shaded.com.google.common.common.collect.Lists;
import com.demo.jxls.poi.ExportLopPlanQuoteCarVo;
import net.jxls.ExcelHelper;
import net.sf.jxls.formula.CellRef;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by liliang on 2017/4/12.
 */
public class MergeExcelTest {

    private static String template = "plan_quote_tmpl.xls";
    private static String output = "target/plan_quote_tmpl_out.xls";

    @Test
    public void mergeBaseTest() throws IOException, InvalidFormatException {
        InputStream is = MergeExcelTest.class.getResourceAsStream(template);
        OutputStream outputStream = new FileOutputStream(output);
        Workbook wb = WorkbookFactory.create(is);
        Sheet sheet = wb.getSheet("template");
        String startCellRef = "B19";
        Cell startCell = ExcelHelper.getCellByCellRef(sheet, startCellRef);
        int i,j = 0;
        List<ExportLopPlanQuoteCarVo> quoteCarVoList = Lists.newLinkedList();
        ExportLopPlanQuoteCarVo quoteCarVo = new ExportLopPlanQuoteCarVo();
        quoteCarVo.setName("哈哈");
        quoteCarVo.setNum(25);
        quoteCarVo.setPrice(BigDecimal.valueOf(1000F));
        quoteCarVo.setTotalPrice(BigDecimal.valueOf(1000F));

        quoteCarVoList.add(quoteCarVo);
        quoteCarVoList.add(quoteCarVo);
        //quoteCarVoList.add(quoteCarVo);
        //quoteCarVoList.add(quoteCarVo);

        if(!quoteCarVoList.isEmpty()){
            int size = quoteCarVoList.size();
            if(size > 3){//
            }else{//直接写入就好
                for(ExportLopPlanQuoteCarVo carVo : quoteCarVoList){
                    //每一行
                    for(j = 0; j < 5; j++){
                        setCellValue(startCell,carVo.getName());
                    }
                    ExcelHelper.getCellByCellRef(sheet, "B20");
                    insertRow(sheet,19,1);
                    j = 0;//一行完毕
                }
            }
        }



        wb.setSheetName(0, String.valueOf(40 + "人"));//人数 FIXME
        wb.write(outputStream);
    }

    @Test
    public void testCellRef()
    {
        //CellRef cellRef = new CellRef("B19");

    }
}

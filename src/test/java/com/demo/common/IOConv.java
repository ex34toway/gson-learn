package com.demo.common;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.junit.Test;

import java.io.*;

/**
 * Created by liliang on 2017/4/21.
 */
public class IOConv {
    private static String template = "car_template.xls";

    @Test
    public void testBase() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        InputStream is = IOConv.class.getResourceAsStream(template);
        POIFSFileSystem fs = new POIFSFileSystem(is);
        HSSFWorkbook wb = new HSSFWorkbook(fs);
        HSSFSheet sheet = wb.getSheetAt(0);

        wb.write(baos);

        InputStream in = new ByteArrayInputStream(baos.toByteArray());
    }
}

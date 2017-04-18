package com.demo.jxls.poi.reader;

import autovalue.shaded.com.google.common.common.collect.Lists;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liliang on 2017/4/18.
 */
public class JXLSReaderTest {

    static Logger logger = LoggerFactory.getLogger(JXLSReaderTest.class);

    private static final String config_file = "persons.xml";

    private static final String data_file = "persons.xls";

    @Test
    public void testBase() throws IOException, SAXException, InvalidFormatException
    {
        execute();
    }

    private static void execute() throws IOException, SAXException, InvalidFormatException {
        logger.info("Reading xml config file and constructing XLSReader");
        try(InputStream xmlInputStream = JXLSReaderTest.class.getResourceAsStream(config_file)) {
            XLSReader reader = ReaderBuilder.buildFromXML(xmlInputStream);
            try (InputStream xlsInputStream = JXLSReaderTest.class.getResourceAsStream(data_file)) {
                List<FileInfo> fileInfoList = Lists.newArrayList();
                Map<String, Object> beans = new HashMap<>();
                beans.put("fileList", fileInfoList);
                logger.info("Reading the data...");
                reader.read(xlsInputStream, beans);
                logger.info("Read " + fileInfoList.size() + " departments into `departments` list");
                logger.info("Printing IT department employees and birthdays:");
                for (FileInfo fileInfo :fileInfoList) {
                    logger.info(fileInfo.getName() + ": " + fileInfo.getSize());
                }
            }
        }
    }
}

package com.demo.jxls.poi;

import autovalue.shaded.com.google.common.common.collect.Lists;
import com.demo.guava.range.Person;
import com.demo.model.Department;
import com.demo.model.Employee;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.jxls.area.Area;
import org.jxls.area.XlsArea;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xml.XmlAreaBuilder;
import org.jxls.command.*;
import org.jxls.common.AreaRef;
import org.jxls.common.CellData;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.cellshift.AdjacentCellShiftStrategy;
import org.jxls.common.cellshift.InnerCellShiftStrategy;
import org.jxls.demo.*;
import org.jxls.transform.Transformer;
import org.jxls.transform.poi.PoiTransformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liliang on 2017/4/11.
 */
public class EachCommandDemo {
    static Logger logger = LoggerFactory.getLogger(org.jxls.demo.EachIfCommandDemo.class);
    private static String template = "car_template.xls";
    private static String xmlConfig = "car_3.xml";
    private static String output = "target/car_output.xls";

    public static void main(String[] args) throws IOException, InvalidFormatException {
        logger.info("Running Each/If Command XML Builder demo");
        execute();
    }

    public static void execute() throws IOException, InvalidFormatException {
        List<Department> departments = createDepartments();
        URL url = EachCommandDemo.class.getResource("");
        logger.info("Opening input stream");
        InputStream is = EachCommandDemo.class.getResourceAsStream(template);
        Workbook wb = WorkbookFactory.create(is);
        OutputStream os = new FileOutputStream(output);
        //Transformer transformer = TransformerFactory.createTransformer(is, os);
        PoiTransformer transformer = PoiTransformer.createTransformer(wb);
        transformer.setOutputStream(os);
        //transformer.set
        System.out.println("Creating areas");
        InputStream configInputStream = EachCommandDemo.class.getResourceAsStream(xmlConfig);
        AreaBuilder areaBuilder = new XmlAreaBuilder(configInputStream, transformer);
        List<Area> xlsAreaList = areaBuilder.build();
        Area xlsArea = xlsAreaList.get(0);
        Area xlsArea2 = xlsAreaList.get(1);
        Context context = new Context();
        List<ExportLopPlanQuoteCarVo> interCarVoList = Lists.newLinkedList();
        ExportLopPlanQuoteCarVo vo =  new ExportLopPlanQuoteCarVo();
        vo.setDummyName("国内团队用车（人民币）");
        vo.setName("哈哈");
        vo.setPrice(BigDecimal.valueOf(100f));
        vo.setTotalPrice(BigDecimal.valueOf(100f));
        vo.setNum(20);
        interCarVoList.add(vo);
        interCarVoList.add(vo);
        interCarVoList.add(vo);
        interCarVoList.add(vo);
        context.putVar("interCarVoList", interCarVoList);
        context.putVar("updateCellMergeCellUpdater",new UpdateCellMergeCellUpdater());
        logger.info("Applying first area at cell " + new CellRef("40人!B2"));
        CellRef outExcel = new CellRef("40人!B2");
        CellRef mergeCell = null;
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        int curRow = outExcel.getRow();
        int curCol = outExcel.getCol();
        int dataSize = interCarVoList.size();
        if(dataSize > 1){//模板默认占一行
            curRow += (dataSize+2);//统计占一行
            //curCol 不变
        }else{
            curRow += 2;
        }
        xlsArea.setCellShiftStrategy(new InnerCellShiftStrategy());
        xlsArea.applyAt(outExcel, context);
        xlsArea.processFormulas();

        //继续往下写
        //改变原有单元格范围
        if(dataSize > 1){//插入了数据
            sheet = wb.getSheet("car");
            mergeCell = outExcel.setRow(curRow + 1);//就是开始Cell向下一行
            sheet.addMergedRegion(new CellRangeAddress(mergeCell.getRow(),mergeCell.getRow()+dataSize+2,mergeCell.getCol(),mergeCell.getCol()));
            //
            CellData cellData = new CellData(mergeCell, CellData.CellType.STRING,"国内团队用车（人民币）");

            xlsArea.addAreaListener(new MergeHeaderColAreaListener(new CellRangeAddress(1,1,1,1)));
            outExcel = outExcel.setRow(curRow);
        }else{
            //刚好把模板内容给填充
        }
        xlsArea2.setCellShiftStrategy(new InnerCellShiftStrategy());
        xlsArea2.applyAt(outExcel, context);
        xlsArea2.processFormulas();
        logger.info("Complete");
        transformer.deleteSheet("car");//删除模板表
        transformer.deleteSheet("car2");//删除模板表
        transformer.write();
        logger.info("written to file");
    }

    public static void addMerge()
    {
        Sheet sheet = null;
        CellRangeAddress region = new CellRangeAddress(1,1,1,1);
        sheet.addMergedRegion(region);
    }

    public static List<Department> createDepartments() {
        List<Department> departments = new ArrayList<Department>();
        Department department = new Department("IT");
        Employee chief = new Employee("Derek", 35, 3000, 0.30);
        department.setChief(chief);
        department.setLink("http://jxls.sf.net");
        department.addEmployee(new Employee("Elsa", 28, 1500, 0.15));
        department.addEmployee(new Employee("Oleg", 32, 2300, 0.25));
        department.addEmployee(new Employee("Neil", 34, 2500, 0.00));
        department.addEmployee(new Employee("Maria", 34, 1700, 0.15));
        department.addEmployee(new Employee("John", 35, 2800, 0.20));
        departments.add(department);
        department = new Department("HR");
        chief = new Employee("Betsy", 37, 2200, 0.30);
        department.setChief(chief);
        department.setLink("http://jxls.sf.net");
        department.addEmployee(new Employee("Olga", 26, 1400, 0.20));
        department.addEmployee(new Employee("Helen", 30, 2100, 0.10));
        department.addEmployee(new Employee("Keith", 24, 1800, 0.15));
        department.addEmployee(new Employee("Cat", 34, 1900, 0.15));
        departments.add(department);
        department = new Department("BA");
        chief = new Employee("Wendy", 35, 2900, 0.35);
        department.setChief(chief);
        department.setLink("http://jxls.sf.net");
        department.addEmployee(new Employee("Denise", 30, 2400, 0.20));
        department.addEmployee(new Employee("LeAnn", 32, 2200, 0.15));
        department.addEmployee(new Employee("Natali", 28, 2600, 0.10));
        department.addEmployee(new Employee("Martha", 33, 2150, 0.25));
        departments.add(department);
        return departments;
    }
}

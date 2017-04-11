package com.demo.jxls.poi;

import autovalue.shaded.com.google.common.common.collect.Lists;
import com.demo.guava.range.Person;
import com.demo.model.Department;
import com.demo.model.Employee;
import org.jxls.area.Area;
import org.jxls.area.XlsArea;
import org.jxls.builder.AreaBuilder;
import org.jxls.builder.xml.XmlAreaBuilder;
import org.jxls.command.Command;
import org.jxls.command.EachCommand;
import org.jxls.command.IfCommand;
import org.jxls.common.AreaRef;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.demo.*;
import org.jxls.transform.Transformer;
import org.jxls.util.JxlsHelper;
import org.jxls.util.TransformerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
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

    public static void main(String[] args) throws IOException {
        logger.info("Running Each/If Command XML Builder demo");
        execute();
    }

    public static void execute() throws IOException {
        List<Department> departments = createDepartments();
        logger.info("Opening input stream");
        InputStream is = EachCommandDemo.class.getResourceAsStream(template);
        OutputStream os = new FileOutputStream(output);
        Transformer transformer = TransformerFactory.createTransformer(is, os);
        System.out.println("Creating areas");
        InputStream configInputStream = EachCommandDemo.class.getResourceAsStream(xmlConfig);
        AreaBuilder areaBuilder = new XmlAreaBuilder(configInputStream, transformer);
        List<Area> xlsAreaList = areaBuilder.build();
        Area xlsArea = xlsAreaList.get(0);
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
        xlsArea.applyAt(new CellRef("40人!B2"), context);
        xlsArea.processFormulas();
        logger.info("Complete");
        transformer.deleteSheet("Template");//删除模板表
        transformer.write();
        logger.info("written to file");
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

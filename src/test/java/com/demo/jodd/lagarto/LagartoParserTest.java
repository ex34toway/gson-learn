package com.demo.jodd.lagarto;

import static jodd.jerry.Jerry.jerry;

import jodd.jerry.Jerry;
import org.junit.Test;

/**
 * Created by liliang on 2017/4/14.
 */
public class LagartoParserTest {

    @Test
    public void testBase()
    {

    }

    @Test
    public void testBaseJerry(){
        Jerry doc = jerry("<p>啊啊实打实大苏打似的<br></p> <p><br></p>");
        System.out.println(doc.text());
        doc = jerry("<span>other</span>");
        System.out.println(doc.text());
    }
}

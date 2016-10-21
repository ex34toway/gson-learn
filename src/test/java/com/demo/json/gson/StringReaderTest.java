package com.demo.json.gson;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by liliang on 2016/9/22.
 */
public class StringReaderTest {

    @Test
    public void testBase() throws IOException {
        StringReader reader = new StringReader("{'name':'liming'}");
        int c = -1;
        while(( c = reader.read()) != -1){
            System.out.print((char)c);
        }
        System.out.println();
        reader.close();
    }
}

package com.demo.guava.concurrent;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by liliang on 2017/1/7.
 */
public class ConcurrentHashMapTest {

    @Test
    public void testBase()
    {
        ConcurrentHashMap<String,Object> conMap = new ConcurrentHashMap<String,Object>();
        conMap.put("name","yijtx");
    }
}

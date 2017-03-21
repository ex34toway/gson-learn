package com.demo.spi.impl;

import com.demo.spi.IService;

/**
 * Created by liliang on 2017/2/24.
 */
public class HDFSService implements IService{

    @Override
    public String sayHello() {
        return "Hello HDFS!";
    }

    @Override
    public String getScheme() {
        return "hdfs";
    }
}

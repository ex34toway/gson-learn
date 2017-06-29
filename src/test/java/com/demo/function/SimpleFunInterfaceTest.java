package com.demo.function;

import org.junit.Test;

/**
 * Created by liliang on 2017/6/29.
 */
public class SimpleFunInterfaceTest {

    /**
     * 任务管道
     * @param sfi
     */
    public static void carryOutWork(SimpleFuncInterface sfi){
        sfi.doWork();
    }

    @Test
    public void testBase()
    {
        carryOutWork(new SimpleFuncInterface() {
            @Override
            public void doWork() {
                System.out.println("Do work in SimpleFun impl...");
            }
        });
        carryOutWork(() -> System.out.println("Do work in lambda exp impl..."));
    }

    @Test
    public void testDefaultImpl()
    {
        DefaultMethodSample defaultMethodSample = new DefaultMethodSample();
        defaultMethodSample.doWork();
    }
}

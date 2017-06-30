package com.demo.guava.concurrent.counter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by liliang on 2017/6/30.
 */
public class SimpleCounterTest {

    private CounterManager counterManager = new SimpleCounterManager();

    private long ret = 0;

    @Test
    public void testRaw() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(counterManager.getCounter("test").getAndAdd(1))).start();
        }

        Thread.sleep(5000);
        Assert.assertEquals(counterManager.getCounter("test").get(), 100);
    }

    @Test
    public void testSimple() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> counterManager.getCounter("test").increment()).start();
        }

        Thread.sleep(500);
        Assert.assertEquals(counterManager.getCounter("test").get(), 100);
    }
}

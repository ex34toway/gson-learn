package com.demo.guava.concurrent.counter;

/**
 * Created by liliang on 2017/6/30.
 */
public class SimpleCounterManager extends AbstractCounterManager {
    @Override
    protected Counter createCount(String name) {
        return new SimpleCounter();
    }
}

package com.demo.guava.concurrent.counter;

/**
 * Created by liliang on 2017/6/30.
 */
public interface CounterManager {

    Counter getCounter(String name);
}

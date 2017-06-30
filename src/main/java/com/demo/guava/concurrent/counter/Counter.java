package com.demo.guava.concurrent.counter;

/**
 * Created by liliang on 2017/6/30.
 */
public interface Counter {
    long get();

    void set(long num);

    long getAndAdd(long num);

    void add(long num);

    void increment();

    void decrement();

    long incrementAndGet();

    long decrementAndGet();
}

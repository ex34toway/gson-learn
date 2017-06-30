package com.demo.guava.concurrent.counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by liliang on 2017/6/30.
 */
public class SimpleCounter implements Counter{

    private final AtomicLong counter = new AtomicLong();

    @Override
    public long get() {
        return counter.get();
    }

    @Override
    public void set(long num) {
        counter.set(num);
    }

    @Override
    public long getAndAdd(long num) {
        return counter.getAndAdd(num);
    }

    @Override
    public void add(long num) {
        counter.addAndGet(num);
    }

    @Override
    public void increment() {
        counter.incrementAndGet();
    }

    @Override
    public void decrement() {
        counter.decrementAndGet();
    }

    @Override
    public long incrementAndGet() {
        return counter.incrementAndGet();
    }

    @Override
    public long decrementAndGet() {
        return counter.decrementAndGet();
    }
}

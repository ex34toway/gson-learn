package com.demo.guava.concurrent.counter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liliang on 2017/6/30.
 */
public abstract class AbstractCounterManager implements CounterManager {

    private final Map<String, Counter> counterStore = new HashMap<>(128);

    @Override
    public Counter getCounter(String name) {
        Counter counter = counterStore.get(name);
        if (counter != null)
            return counter;
        synchronized (counterStore) {
            return counterStore.computeIfAbsent(name, this::createCount);
        }
    }

    protected abstract Counter createCount(String name);
}

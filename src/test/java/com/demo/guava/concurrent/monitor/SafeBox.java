package com.demo.guava.concurrent.monitor;

import com.google.common.util.concurrent.Monitor;

/**
 * Created by liliang on 2017/1/7.
 */
public class SafeBox<T> {

    private final Monitor monitor = new Monitor();

    private final Monitor.Guard valuePresent = new Monitor.Guard(monitor) {
        public boolean isSatisfied() {
            return value != null;
        }
    };

    private final Monitor.Guard valueAbsent = new Monitor.Guard(monitor) {
        public boolean isSatisfied() {
            return value == null;
        }
    };

    private T value;

    public T get() throws InterruptedException {
        monitor.enterWhen(valuePresent);
        try {
            T result = value;
            value = null;
            return result;
        } finally {
            monitor.leave();
        }
    }

    public void set(T value) throws InterruptedException {
        monitor.enterWhen(valueAbsent);
        try {
            this.value = value;
        } finally {
            monitor.leave();
        }
    }
}

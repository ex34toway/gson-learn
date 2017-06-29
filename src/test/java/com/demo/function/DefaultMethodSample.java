package com.demo.function;

/**
 * Created by liliang on 2017/6/29.
 */
public class DefaultMethodSample implements SimpleFuncInterface,ComplexFunctionalInterface{
    @Override
    public void doWork() {
        doSomeWork();
        doSomeOtherWork();
    }

    @Override
    public void doSomeWork() {

    }

    @Override
    public void doSomeOtherWork() {

    }
}

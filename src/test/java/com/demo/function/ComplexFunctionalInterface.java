package com.demo.function;

/**
 * Created by liliang on 2017/6/29.
 */
@FunctionalInterface
public interface ComplexFunctionalInterface extends SimpleFuncInterface{

    default public void doSomeWork(){
        System.out.println("Doing some work in interface impl...");
    }

    default public void doSomeOtherWork(){
        System.out.println("Doing some other work in interface impl...");
    }
}

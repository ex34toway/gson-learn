package com.demo.cglib;

/**
 * Created by liliang on 2017/3/21.
 */
public class Subject {

    private String name;

    public void targetMethod()
    {
        System.out.println("I'm target method");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

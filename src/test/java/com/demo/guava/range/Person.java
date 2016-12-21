package com.demo.guava.range;

import com.google.common.collect.ComparisonChain;

import java.util.Comparator;

/**
 * Created by liliang on 2016/12/20.
 */
public class Person implements Comparable<Person>{
    private String firstName;
    private String lastName;
    private int age;
    private String sex;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public int compareTo(Person o) {
        return ComparisonChain.start().
                compare(this.firstName,o.getFirstName()).
                compare(this.lastName,o.getLastName()).
                compare(this.age,o.getAge()).
                compare(this.sex,o.getSex()).result();
    }
}

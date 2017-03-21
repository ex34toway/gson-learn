package com.demo.autovalue;

import com.google.auto.value.AutoValue;

/**
 * Created by liliang on 2017/3/21.
 */
@AutoValue
abstract class Animal {
    static Animal create(String name,int numberOfLegs) {
        // See "How do I...?" below for nested classes.
        return new AutoValue_Animal(name, numberOfLegs);
    }

    abstract String name();

    abstract int numberOfLegs();
}
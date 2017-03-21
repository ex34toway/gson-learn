package com.demo.autovalue;

import com.google.auto.value.AutoValue;
import com.sun.istack.internal.Nullable;

/**
 * Created by liliang on 2017/3/21.
 */
@AutoValue
abstract class Person {
    static Builder builder() {
        return new AutoValue_Person.Builder();
    }

    @Nullable abstract String name();
    abstract int id();

    @AutoValue.Builder
    public interface Builder {
        Builder name(String x);
        Builder id(int x);
        Person build();
    }
}
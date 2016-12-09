package com.demo.guava.iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liliang on 2016/11/13.
 */
public class FluentIterableTest {

    @Test
    public void testBase()
    {
        List<String> nameList = Lists.newLinkedList(Arrays.asList("xiao","li","ming"));
        List<String> result = FluentIterable.from(nameList).filter(new Predicate<String>() {
            @Override
            public boolean apply(String input) {
                return input.equals("li");
            }
        }).toList();// ==> find li
        assertThat(Iterables.contains(result,"li"),is(true));
    }
}

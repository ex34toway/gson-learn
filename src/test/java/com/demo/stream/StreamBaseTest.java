package com.demo.stream;

import static org.junit.Assert.*;

import akka.util.Collections$;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by liliang on 2017/6/30.
 */
public class StreamBaseTest
{
    @Test
    public void testBase()
    {
        List<String> stringList = Lists.newLinkedList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");
        stringList.add("5");

        long count =
                stringList.stream().filter(strNum -> Integer.parseInt(strNum) < 3).count();
        System.out.println(count);

        List<String> ret = stringList.stream().filter(strNum -> Integer.parseInt(strNum) < 3)
                .collect(Collectors.toList());
        assertEquals(count,ret.size());
        ret.forEach(x -> System.out.println(x));

        List<Integer> intRet =
                stringList.stream().mapToInt(str -> Integer.valueOf(str)).boxed().collect(Collectors.toList());
        intRet.forEach(x -> System.out.println(x));
    }
}

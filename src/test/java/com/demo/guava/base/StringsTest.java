package com.demo.guava.base;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by liliang on 2017/5/8.
 */
public class StringsTest {

    @Test
    public void testPadding()
    {
        System.out.println(Strings.padStart("1", 3, '0'));
        System.out.println(Strings.padStart("10", 3, '0'));
        System.out.println(Strings.padStart("100", 3, '0'));
        System.out.println(Strings.padStart("1000", 3, '0'));
    }
}

package com.demo.guava.string;

import static com.google.common.base.Strings.*;
import static org.junit.Assert.*;

import com.google.common.base.CaseFormat;
import org.junit.Test;

/**
 * Created by liliang on 2017/4/21.
 */
public class GuavaStringsTest {

    @Test
    public void testBase()
    {
        assertEquals("",nullToEmpty(null));
        assertEquals(null,emptyToNull(null));
    }

    @Test
    public void padding()
    {
        System.out.println(padStart("1", 2, '0'));
    }

    @Test
    public void testCaseFormat()
    {
        String data = "test_data";
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }
}

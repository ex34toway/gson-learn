package com.demo.guava.string;

import static com.google.common.base.Strings.*;
import static org.junit.Assert.*;

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
}

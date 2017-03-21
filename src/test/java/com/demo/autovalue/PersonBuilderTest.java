package com.demo.autovalue;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by liliang on 2017/3/21.
 */
public class PersonBuilderTest {

    @Test
    public void testBase()
    {
        Person person = Person.builder().id(1).build();
        assertEquals(person.name(),null);
    }
}

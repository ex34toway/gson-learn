package com.demo.autovalue;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Created by liliang on 2017/3/21.
 */
public class AnimalTest {

    @Test
    public void testBase()
    {
        Animal dog = Animal.create(null, 4);
        assertEquals("dog", dog.name());
        assertEquals(4, dog.numberOfLegs());

        // You probably don't need to write assertions like these; just illustrating.
        assertTrue(Animal.create("dog", 4).equals(dog));
        assertFalse(Animal.create("cat", 4).equals(dog));
        assertFalse(Animal.create("dog", 2).equals(dog));

        assertEquals("Animal{name=dog, numberOfLegs=4}", dog.toString());
    }
}

package com.demo.guava.range;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Range;
import org.junit.Test;

/**
 * Created by liliang on 2016/12/20.
 */
public class RangeTest {

    @Test
    public void baseTest()
    {
        Range<Integer> ageRange = Range.closed(20,35);
        Function<Person,Integer> ageFunction = new Function<Person,
                Integer>() {
            @Override
            public Integer apply(Person person) {
                return person.getAge();
            }
        };

        /**
         * Returns the composition of a function and a predicate. For every {@code x},
         * the generated predicate returns {@code predicate(function(x))}.
         */
        Predicate<Person> personPredicate = Predicates.compose(ageRange, ageFunction);
    }
}

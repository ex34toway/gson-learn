package com.demo.guava.coll.map;

import static org.junit.Assert.*;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by liliang on 2017/6/29.
 */
public class MapTransformTest {

    @Test
    public void testJoinerMapRequestParam()
    {
        Map<String,String> requestParam = Maps.newHashMap();
        requestParam.put("id","test");
        requestParam.put("name","test");

        String requestStr = Joiner.on("&").withKeyValueSeparator("=").join(requestParam);
        System.out.println(requestStr);

        Map<String,String> converted = Splitter.on("&").withKeyValueSeparator("=").split(requestStr);
        for (Map.Entry<String,String> entry : converted.entrySet()){
            System.out.println("key: "+entry.getKey()+" - value: "+entry.getValue());
        }
    }

    @Test
    public void testMapsTransform()
    {
        Map<String,Integer> nameAgeMap = Maps.newHashMap();
        nameAgeMap.put("test",15);
        nameAgeMap.put("tom",34);
        nameAgeMap.put("cat",25);


        // transform
        Map<String,String> labeledMap = Maps.transformEntries(nameAgeMap,new Maps.EntryTransformer<String,Integer,String>(){
            @Override
            public String transformEntry(String key, Integer value) {
                return value > 18 ? "成年" : "未成年";
            }
        });

        // predicate
        Map<String,Integer> adultMap = Maps.filterValues(nameAgeMap, new Predicate<Integer>() {
            @Override
            public boolean apply(Integer input) {
                return input > 18;
            }
        });
        for (Map.Entry<String,Integer> entry : adultMap.entrySet()){
            System.out.println("key: "+entry.getKey()+" - value: "+entry.getValue());
        }
    }

    @Test
    public void testMultimap()
    {
        // Base
        Map<String,List<String>> namePhoneMap = Maps.newHashMap();
        namePhoneMap.put("test",Lists.newArrayList("122222","12313213213"));
        System.out.println(namePhoneMap.size());

        // Multimap
        Multimap<String,String> namePhoneMultiMap = ArrayListMultimap.create();// --> Map<String,List<String>>
        namePhoneMultiMap.put("test","122222");
        namePhoneMultiMap.put("test","12313213213");

        System.out.println(namePhoneMultiMap.size());
        List<String> result = (List<String>)namePhoneMultiMap.get("test");
        assertEquals(2,result.size());
        result.forEach((x)->{
            System.out.println(x);
        });
    }
}

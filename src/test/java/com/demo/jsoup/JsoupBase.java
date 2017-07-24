package com.demo.jsoup;

import com.google.common.collect.Maps;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by liliang on 2017/7/19.
 */
public class JsoupBase {

    @Test
    public void testBase() throws IOException {
        Document doc = Jsoup.connect("http://localhost/").get();
        Elements body = doc.select("body");
        System.out.println(body.text());
    }

    @Test
    public void testTreeMap() {
        Map<String,Integer> treeMap = Maps.newTreeMap();
        treeMap.put("1",1);
        treeMap.put("2",1);
        treeMap.put("3",1);
        treeMap.put("4",1);
        treeMap.put("5",1);
        treeMap.put("6",1);
        treeMap.put("7",1);
        treeMap.put("8",1);

        if(treeMap.containsKey("5")){
            treeMap.remove("5");
        }

    }
}

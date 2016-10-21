package com.demo.json.gson;

import com.demo.json.domain.AlbumImages;
import com.demo.json.domain.Albums;
import com.demo.json.domain.DataSet;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;

public class GsonBaseTest {

    private static GsonBuilder builder = null;

    @Before
    public void setUp()
    {
        builder = new GsonBuilder();
    }

    @Test
    public void testBase()
    {
        Albums albums = new Albums();
        albums.title = "Free Music Archive - Albums";
        albums.message = "";
        albums.total = "11259";
        albums.total_pages = 2252;
        albums.page = 1;
        albums.limit = "5";
        DataSet ds = new DataSet();
        ds.images.add(new AlbumImages());
        albums.dataset.add(ds);
        Gson gson = builder.create();
        System.out.println(gson.toJson(albums));
    }

    @Test
    public void testSerializeNulls()
    {
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        Gson gson = builder.create();
        System.out.println(gson.toJson(image));
        System.out.println("------------------");
        builder.serializeNulls();
        gson = builder.create();
        System.out.println(gson.toJson(image));
    }

    @Test
    public void test()
    {
        AlbumImages image = new AlbumImages();
        image.image_id = "1";
        builder.serializeNulls();
        Gson gson = builder.setFieldNamingStrategy(new FieldNamingStrategy(){
            @Override
            public String translateName(Field f) {
                return f.getName().equals("image_id") ? "id" : f.getName();
            }
        }).create();
        System.out.println(gson.toJson(image));
    }
}

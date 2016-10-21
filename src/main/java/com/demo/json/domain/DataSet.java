package com.demo.json.domain;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liliang on 2016/9/22.
 */
public class DataSet {
    public String album_id;
    public String album_title;
    @SerializedName("album_images")
    public List<AlbumImages> images = new ArrayList<AlbumImages>();
}

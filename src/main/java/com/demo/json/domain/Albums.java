package com.demo.json.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liliang on 2016/9/22.
 */
public class Albums {
    public String title;
    public String message;
    public List<String> errors = new ArrayList<String>();
    public String total;
    public int total_pages;
    public int page;
    public String limit;
    public List<DataSet> dataset = new ArrayList<DataSet>();
}

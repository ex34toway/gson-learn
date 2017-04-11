package com.demo.jxls.poi;

import java.math.BigDecimal;

/**
 * Created by liliang on 2017/4/11.
 */
public class ExportLopPlanQuoteCarVo {
    private String dummyName;
    //
    private String name;
    //单价
    private BigDecimal price;
    //汇率 当地
    private BigDecimal rate;
    //
    private Integer num;
    //总价
    private BigDecimal totalPrice;

    public String getDummyName() {
        return dummyName;
    }

    public void setDummyName(String dummyName) {
        this.dummyName = dummyName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}

package com.demo.jxls.poi;

import java.util.List;

/**
 * Created by liliang on 2017/4/11.
 */
public class ExportLopPlanQuoteCarWrapperVo {

    private String dummyName;

    List<ExportLopPlanQuoteCarVo> quoteCarVoList;

    public String getDummyName() {
        return dummyName;
    }

    public void setDummyName(String dummyName) {
        this.dummyName = dummyName;
    }

    public List<ExportLopPlanQuoteCarVo> getQuoteCarVoList() {
        return quoteCarVoList;
    }

    public void setQuoteCarVoList(List<ExportLopPlanQuoteCarVo> quoteCarVoList) {
        this.quoteCarVoList = quoteCarVoList;
    }
}

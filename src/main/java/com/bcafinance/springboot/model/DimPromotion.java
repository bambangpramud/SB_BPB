/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/22/2022  10:42 AM
Last Modified on 11/22/202210:42 AM
Version 1.0
*/


package com.bcafinance.springboot.model;


import java.util.Date;

public class DimPromotion {



private long promotionKey;

private String englishPromotionName;

private Float discountPct;

private String startDate;

private String endDate;

    public DimPromotion(Long promotionKey, String englishPromotionName, Float discountPct, String startDate, String endDate) {
        this.promotionKey = promotionKey;
        this.englishPromotionName = englishPromotionName;
        this.discountPct = discountPct;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DimPromotion(String englishPromotionName, Float discountPct, String startDate, String endDate) {
        this.englishPromotionName = englishPromotionName;
        this.discountPct = discountPct;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public DimPromotion() {
    }

    public long getPromotionKey() {
        return promotionKey;
    }

    public void setPromotionKey(long promotionKey) {
        this.promotionKey = promotionKey;
    }

    public String getEnglishPromotionName() {
        return englishPromotionName;
    }

    public void setEnglishPromotionName(String englishPromotionName) {
        this.englishPromotionName = englishPromotionName;
    }

    public Float getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(Float discountPct) {
        this.discountPct = discountPct;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

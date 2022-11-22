package com.bcafinance.springboot.repository;

import com.bcafinance.springboot.model.DimPromotion;

import java.text.ParseException;
import java.util.List;

public interface DimPromotionRepository {

    long save(DimPromotion dp) throws ParseException;

    long update(DimPromotion dp) throws ParseException;

    DimPromotion findById(long id);

    long deleteById(long id);

    List<DimPromotion> findAll();
    List<DimPromotion> findByPromotionName(String promotionName);
    int deleteAll();
}

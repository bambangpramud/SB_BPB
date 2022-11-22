/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/22/2022  10:57 AM
Last Modified on 11/22/202210:57 AM
Version 1.0
*/


package com.bcafinance.springboot.repository;

import com.bcafinance.springboot.model.DimPromotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class JDBCDimPromotionRepository implements DimPromotionRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long save(DimPromotion dp) throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
        return jdbcTemplate.update("INSERT INTO DimPromotion (EnglishPromotionName,DiscountPct,StartDate,EndDate) VALUES(?,?,?,?)",
                new Object[] {dp.getEnglishPromotionName(),
                 dp.getDiscountPct(),
                        formatter1.parse(dp.getStartDate()),
                        formatter1.parse(dp.getEndDate())

    });
    }




    @Override
    public long update(DimPromotion dp) throws ParseException {
        SimpleDateFormat formatter1=new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter2=new SimpleDateFormat("dd/MM/yyyy");
        return jdbcTemplate.update("UPDATE DimPromotion SET EnglishPromotionName=?,DiscountPct=?,StartDate=?,EndDate=? WHERE PromotionKey=?",
                new Object[] {dp.getEnglishPromotionName(),
                        dp.getDiscountPct(),
                        formatter1.parse(dp.getStartDate()),
                        formatter1.parse(dp.getEndDate()),
                dp.getPromotionKey()});
    }

    @Override
    public DimPromotion findById(long id) {
        try{
            DimPromotion dimPromotion = jdbcTemplate.queryForObject("SELECT * FROM DimPromotion WHERE PromotionKey=?",
                    BeanPropertyRowMapper.newInstance(DimPromotion.class), id);
//            Log.info(dimPromotion.toString());
            return dimPromotion;
        } catch (
                Exception e) {
            return null;
        }
    }

    @Override
    public long deleteById(long id) {
        return jdbcTemplate.update("DELETE FROM DimPromotion WHERE PromotionKey=?", id);
    }

    @Override
    public List<DimPromotion> findAll() {
        return jdbcTemplate.query("SELECT * from Dimpromotion", BeanPropertyRowMapper.newInstance(DimPromotion.class));
    }

    @Override
    public List<DimPromotion> findByPromotionName(String englishPromotionName) {
        return jdbcTemplate.query("SELECT * from DimPromotion WHERE EnglishPromotionName=?",
                BeanPropertyRowMapper.newInstance(DimPromotion.class), englishPromotionName);
    }

    @Override
    public int deleteAll() {
        return 0;
    }
}

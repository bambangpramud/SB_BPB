/*
@Author Bambang a.k.a. Bambang
calon menantu idaman
created with Eclipse intellij 2022.2.3
Created on 11/22/2022  10:56 AM
Last Modified on 11/22/202210:56 AM
Version 1.0
*/


package com.bcafinance.springboot.controller;

import com.bcafinance.springboot.model.DimPromotion;
import com.bcafinance.springboot.repository.DimPromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DimPromotionController {

    @Autowired
    DimPromotionRepository dimPromotionRepository;


    @GetMapping("/dimpromotion")
    public ResponseEntity<List<DimPromotion>> getDimPromotion(){
        try {
            List<DimPromotion> lsDimPromotion = dimPromotionRepository.findAll();

            if (lsDimPromotion.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimPromotion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/dimpromotion/{id}")
    public ResponseEntity<DimPromotion> getDimPromotionById(@PathVariable("id") long id) {
        DimPromotion dimPromotion = dimPromotionRepository.findById(id);

        if (dimPromotion != null) {
            return new ResponseEntity<>(dimPromotion, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/dimpromotion")
    public ResponseEntity<String> createDimPromotion(@RequestBody DimPromotion dimPromotion) {

        try {
//            public DimCustomer(String firstname, String middlename,
//                    String lastname, String birthdate, String emailaddress, String customeralternatekey) {
            dimPromotionRepository.save(new DimPromotion(dimPromotion.getEnglishPromotionName(),
                    dimPromotion.getDiscountPct(),
                    dimPromotion.getStartDate() ,
             dimPromotion.getEndDate()));
            return new ResponseEntity<>("Data berhasil dibuat.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/dimpromotion/{id}")
    public ResponseEntity<String> updateDimPromotion(@PathVariable("id") long id, @RequestBody DimPromotion dimPromotion) throws ParseException {
        DimPromotion _dimpromotion = dimPromotionRepository.findById(id);

        if (_dimpromotion != null) {
            _dimpromotion.setPromotionKey(id);
            _dimpromotion.setEnglishPromotionName(dimPromotion.getEnglishPromotionName());
            _dimpromotion.setDiscountPct(dimPromotion.getDiscountPct());
            _dimpromotion.setStartDate(dimPromotion.getStartDate().toString());
            _dimpromotion.setEndDate(dimPromotion.getEndDate().toString());

            dimPromotionRepository.update(_dimpromotion);
            return new ResponseEntity<>("Data Berhasil diperbaharui.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Tidak dapat menemukan data dengan id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/dimpromotion/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        try {
            long result = dimPromotionRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Data dengan id " + id +" Tidak ada !!", HttpStatus.OK);
            }
            return new ResponseEntity<>("Data dengan id "+id+" Berhasil di hapus", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data .", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/dimpromotion/6832BLE")
    public ResponseEntity<String> deleteAll() {
        try {
            int numRows = dimPromotionRepository.deleteAll();
            return new ResponseEntity<>("Berhasil Menghapus  " + numRows + " Data .", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Tidak dapat menghapus data.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/dimpromootion/datas/{name}")
    public ResponseEntity<List<DimPromotion>> findByPromotionName(@PathVariable("name") String englishPromotionName) {
        try {
            List<DimPromotion> lsDimPromotion = dimPromotionRepository.findByPromotionName(englishPromotionName);

            if (lsDimPromotion.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(lsDimPromotion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

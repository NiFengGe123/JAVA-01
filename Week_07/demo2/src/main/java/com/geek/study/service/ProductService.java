package com.geek.study.service;

import com.alibaba.fastjson.JSONObject;
import com.geek.study.bo.ProductInfo;
import com.geek.study.mapper.ProductInfoMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * Copyright (C), 2021
 * FileName: SelectService
 * Author:   xzw
 * Date:     2021/3/5 21:35
 * Description:
 */
@Service
public class ProductService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    public ProductInfo queryInfo(){
        return productInfoMapper.queryProductInfo();
    }

    public ProductInfo getProductInfo(){
        return productInfoMapper.updateProductInfo();
    }

    public int saveNewProduct(){
        String productId = RandomStringUtils.randomAlphabetic(6);
        String prodcutCode = RandomStringUtils.randomAlphabetic(7);
        String barCode = RandomStringUtils.randomAlphabetic(7);
        String productName = "玻璃杯"+RandomStringUtils.random(3);
        ProductInfo info = ProductInfo.builder().productId(productId).productCode(prodcutCode).barCode(barCode)
                .productName(productName).price(Math.random()).auditStatus(1).descript("这是一个"+productName)
                .pushStatus(1).productionDate(DateUtils.addWeeks(new Date(),-RandomUtils.nextInt(1,50)))
                .shelfLife(3).build();
        System.out.println("新增商品："+ JSONObject.toJSONString(info));
        return productInfoMapper.saveNewProductInfo(info);
    }
}

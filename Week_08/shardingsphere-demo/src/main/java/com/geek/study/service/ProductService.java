package com.geek.study.service;

import com.alibaba.fastjson.JSONObject;
import com.geek.study.bo.ProductInfo;
import com.geek.study.mapper.ProductInfoMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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

    public ProductInfo queryInfo() {
        return productInfoMapper.queryProductInfo();
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public int updateProductInfo(Long id, String productName) {
        return productInfoMapper.updateProductInfo(id, productName);
    }

    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public int saveNewProduct() {
        String productId = RandomStringUtils.randomAlphabetic(6);
        String prodcutCode = RandomStringUtils.randomAlphabetic(7);
        String barCode = RandomStringUtils.randomAlphabetic(7);
        String productName = "玻璃杯" + RandomStringUtils.random(3);
        ProductInfo info = ProductInfo.builder().productId(productId).productCode(prodcutCode).barCode(barCode)
                .productName(productName).price((double) Math.round(Math.random() * 10000) / 100).auditStatus(1).descript("这是一个" + productName)
                .pushStatus(1).productionDate(DateUtils.addWeeks(new Date(), -RandomUtils.nextInt(1, 50)))
                .shelfLife(3).build();
        System.out.println("新增商品：" + JSONObject.toJSONString(info));
        return productInfoMapper.saveNewProductInfo(info);
    }
}

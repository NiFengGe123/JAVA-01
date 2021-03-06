package com.geek.study.service;

import com.geek.study.bo.ProductInfo;
import com.geek.study.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2021
 * FileName: SelectService
 * Author:   xzw
 * Date:     2021/3/5 21:35
 * Description:
 */
@Service
public class SelectService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    public ProductInfo queryInfo(){
        return productInfoMapper.queryProductInfo();
    }
}

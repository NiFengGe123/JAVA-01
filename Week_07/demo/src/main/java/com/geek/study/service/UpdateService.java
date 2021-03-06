package com.geek.study.service;

import com.geek.study.bo.ProductInfo;
import com.geek.study.mapper.ProductInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C), 2021
 * FileName: UpdateService
 * Author:   xzw
 * Date:     2021/3/5 21:36
 * Description:
 */
@Service
public class UpdateService {

    @Autowired
    private ProductInfoMapper productInfoMapper;

    public ProductInfo updateInfo(){
        return productInfoMapper.updateProductInfo();
    }
}

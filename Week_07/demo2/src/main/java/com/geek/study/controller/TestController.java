package com.geek.study.controller;


import com.geek.study.bo.ProductInfo;
import com.geek.study.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C), 2021
 * FileName: TestController
 * Author:   xzw
 * Date:     2021/3/5 22:02
 * Description:
 */
@RestController
public class TestController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/queryInfo")
    public ProductInfo queryInfo(){
        return productService.queryInfo();
    }

    @RequestMapping("/getInfo")
    public ProductInfo updateInfo(){
        return productService.getProductInfo();
    }

    @RequestMapping("/saveInfo")
    public int saveInfo(){
        return productService.saveNewProduct();
    }
}

package com.geek.study.controller;


import com.geek.study.bo.ProductInfo;
import com.geek.study.service.SelectService;
import com.geek.study.service.UpdateService;
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
    private SelectService selectService;

    @Autowired
    private UpdateService updateService;

    @RequestMapping("/queryInfo")
    public ProductInfo queryInfo(){
        return selectService.queryInfo();
    }

    @RequestMapping("updateInfo")
    public ProductInfo updateInfo(){
        return updateService.updateInfo();
    }
}

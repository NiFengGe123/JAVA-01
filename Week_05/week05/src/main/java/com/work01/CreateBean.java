package com.work01;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过读取xml配置实现java bean的装配
 * Copyright (C), 2021
 * FileName: CreateBean
 * Author:   xzw
 * Date:     2021/2/20 21:56
 * Description:
 */
public class CreateBean {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/work01/application.xml");

        // 1、xml 装配
        Student student01 = (Student) applicationContext.getBean("student01");
        System.out.println(JSONObject.toJSONString(student01));

        //2、注解扫描 装配
        Student02 student02 = (Student02) applicationContext.getBean("student02");
        System.out.println(JSONObject.toJSONString(student02));
    }
}

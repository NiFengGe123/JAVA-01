package com.work01;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Copyright (C), 2021
 * FileName: Student02
 * Author:   xzw
 * Date:     2021/2/20 22:17
 * Description:
 */
@Component
@Data
public class Student02 {
    /**
     * 学号
     */
    private String userId;
    /**
     * 姓名
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;

    Student02() {
        this.userId = "1002";
        this.userName = "离人愁";
        this.age = 20;
    }
}

package com.work01;

import lombok.Data;

/**
 * Copyright (C), 2021
 * FileName: Student
 * Author:   xzw
 * Date:     2021/2/20 21:59
 * Description:
 */
@Data
public class Student {

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
}

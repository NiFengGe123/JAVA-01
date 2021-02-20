package geek.study.work02;

import lombok.Data;

/**
 * Copyright (C), 2021
 * FileName: Student
 * Author:   xzw
 * Date:     2021/2/20 23:21
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

    public Student() {
        this.userId = "1002";
        this.userName = "离人愁";
        this.age = 20;
    }
}

package com.work1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021
 * FileName: Method1
 * Author:   xzw
 * Date:     2021/2/2 21:00
 * Description:
 */
public class Method1 {

    private static String content = "默认值---";
    public static String result = null;

    public static String getContent(String value) {
        return content + value;
    }

    /**
     * 放入对象返回
     * 主线程循环等待是否有值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            result = Method1.getContent("多少黎明又黄昏。");
        }).start();
        while (result == null) {
            Thread.sleep(100L);
        }
        System.out.println(Method1.result);
    }
}

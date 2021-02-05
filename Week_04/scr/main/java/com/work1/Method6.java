package com.work1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021
 * FileName: Method6
 * Author:   xzw
 * Date:     2021/2/2 22:13
 * Description:
 */
public class Method6 {

    private static String content = "默认值---";
    public static String result = null;

    public static String getContent(String value) {
        return content + value;
    }

    /**
     * 使用线程池
     * 放入对象返回
     * 主线程循环等待是否有值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                result = Method6.getContent("多少黎明又黄昏。");
            }
        });
        while (result == null) {
            Thread.sleep(100L);
        }
        executorService.shutdown();
        System.out.println(Method6.result);
    }
}

package com.work1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Copyright (C), 2021
 * FileName: Method7
 * Author:   xzw
 * Date:     2021/2/2 22:16
 * Description:
 */
public class Method7 {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 使用线程池
     * 对象包装返回，使用join阻塞主线程等待返回值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Method5 method5 = new Method5();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                method5.setResult("多少黎明又黄昏。");
            }
        });
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(method5.getResult());
    }
}

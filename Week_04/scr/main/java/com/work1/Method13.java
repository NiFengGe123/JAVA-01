package com.work1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Copyright (C), 2021
 * FileName: Method13
 * Author:   xzw
 * Date:     2021/2/2 23:54
 * Description:
 */
public class Method13 {

    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 对象包装返回，使用join阻塞主线程等待返回值
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Method13 method13 = new Method13();
        Thread thread = new Thread(() -> {
            method13.setResult("多少黎明又黄昏。");
            Thread.currentThread().interrupt();
        });
        thread.start();
        while (!thread.isInterrupted()){
            System.out.println("还未中断");
        }
        System.out.println(method13.getResult());
    }
}

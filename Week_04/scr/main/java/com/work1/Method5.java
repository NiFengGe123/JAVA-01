package com.work1;

/**
 * Copyright (C), 2021
 * FileName: Method5
 * Author:   xzw
 * Date:     2021/2/2 21:58
 * Description:
 */
public class Method5 {

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
        Method5 method5 = new Method5();
        Thread thread = new Thread(() -> {
            method5.setResult("多少黎明又黄昏。");
        });
        thread.start();
        thread.join();
        System.out.println(method5.getResult());
    }
}

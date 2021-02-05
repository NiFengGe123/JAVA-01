package com.work1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Copyright (C), 2021
 * FileName: Method3
 * Author:   xzw
 * Date:     2021/2/2 21:40
 * Description:
 */
public class Method3 implements Callable<String> {
    @Override
    public String call() throws Exception {
        return print();
    }

    private String print() {
        return "there we sat down";
    }

    /**
     * 使用线程池 submit提交Callable直接get返回
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newScheduledThreadPool(2);
        String value = executorService.submit(new Method3()).get();
        executorService.shutdown();
        System.out.println("返回值：" + value);
    }
}

package com.work1;

import java.util.concurrent.*;

/**
 * Copyright (C), 2021
 * FileName: Method2
 * Author:   xzw
 * Date:     2021/2/2 21:26
 * Description:
 */
public class Method2 implements Callable<String> {

    @Override
    public String call() throws Exception {
        return print();
    }

    private String print() {
        return "there we sat down";
    }

    /**
     * 使用线程池Future+Callable包装返回
     *
     * @param args
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(new Method2());
        executorService.shutdown();
        System.out.println("返回值：" + future.get());
    }
}

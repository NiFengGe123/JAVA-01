package com.work1;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Copyright (C), 2021
 * FileName: Method11
 * Author:   xzw
 * Date:     2021/2/2 23:48
 * Description:
 */
public class Method11 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new Random().nextInt()+"---> 北雪";
            }
        });
        new Thread(task).start();
        System.out.println("返回值："+ task.get());
    }
}

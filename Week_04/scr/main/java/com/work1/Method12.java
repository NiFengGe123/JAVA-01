package com.work1;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Copyright (C), 2021
 * FileName: Method12
 * Author:   xzw
 * Date:     2021/2/2 23:51
 * Description:
 */
public class Method12 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return new Random().nextInt()+"---> 朦胧";
            }
        });
        executorService.submit(task);
        executorService.shutdown();
        System.out.println("返回值："+task.get());
    }
}

package com.work1;

import java.util.concurrent.*;

/**
 * Copyright (C), 2021
 * FileName: Method9
 * Author:   xzw
 * Date:     2021/2/2 23:06
 * Description:
 */
public class Method9 {

    public static void main(String[] args) throws InterruptedException {
        final BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(10);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
         CountDownLatch latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int k = i;
            executorService.execute(() -> {
                blockingDeque.push("当前" + k);
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        System.out.println(blockingDeque);
    }
}

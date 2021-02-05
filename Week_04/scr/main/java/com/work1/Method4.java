package com.work1;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Copyright (C), 2021
 * FileName: Method4
 * Author:   xzw
 * Date:     2021/2/2 21:50
 * Description:
 */
public class Method4 {

    /**
     * 使用completableFuture 返回
     *
     * @param args
     */
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() ->
                "first -> "
        )
                .thenApplyAsync(v ->
                        v + " second -> "
                ).join();
        System.out.println("返回值：" + result);
    }
}

package com.work1;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Copyright (C), 2021
 * FileName: Method8
 * Author:   xzw
 * Date:     2021/2/2 22:49
 * Description:
 */
public class Method8 {

    private static void setValue(AtomicReference<String> atomicReference, String value) {
        atomicReference.set(value);
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicReference<String> atomicReference = new AtomicReference<>();
        new Thread(() -> {
            setValue(atomicReference, "生生不息");
        }).start();
        Thread.sleep(100L);
        System.out.println("返回值：" + atomicReference.get());
    }
}

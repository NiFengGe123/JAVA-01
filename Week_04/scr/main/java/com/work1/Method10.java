package com.work1;

import java.util.concurrent.*;

/**
 * Copyright (C), 2021
 * FileName: Method10
 * Author:   xzw
 * Date:     2021/2/2 23:28
 * Description:
 */
public class Method10 implements Runnable {

    static BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(5);
    private int id;
    private CyclicBarrier barrier;

    public Method10(int id, CyclicBarrier barrier) {
        this.id = id;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        synchronized (this) {
            blockingDeque.push("当前" + id);
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
            new Thread(new Method10(i, barrier)).start();
        }
        barrier.reset();
        while (Method10.blockingDeque.size() < 5){
            Thread.sleep(100L);
        }
        System.out.println(Method10.blockingDeque);
    }
}

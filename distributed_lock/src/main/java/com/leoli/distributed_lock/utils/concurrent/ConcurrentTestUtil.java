package com.leoli.distributed_lock.utils.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.function.Consumer;

public class ConcurrentTestUtil {
    private static final int THREADNUM = 50;

    public static <T> void test(T t, Consumer<T> consumer, int threadNum){
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i=0;i<threadNum;i++){
            new Thread(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                consumer.accept(t);
            }).start();
            countDownLatch.countDown();
        }

    }

    public static <T> void test(T t,Consumer<T> consumer){
        test(t,consumer,THREADNUM);
    }
}

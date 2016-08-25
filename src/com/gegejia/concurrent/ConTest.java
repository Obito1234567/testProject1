package com.gegejia.concurrent;

import java.util.Vector;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liugaojian on 2016/8/15.
 */
public class ConTest {

    public static void main(String[] args)
    {

        final Lock lock = new ReentrantLock();

        final Condition rendCon = lock.newCondition();

        final int queueSize = 10;

        final PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(queueSize);

        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                {
                    lock.lock();
                    if (queue.size() == queueSize)
                    {
                        try {
                            System.out.println("队列已满");
                            rendCon.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.offer(1);
                    rendCon.signal();
                }
            }
        }, "producer").start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }, "consumer").start();

        try {
            countDownLatch.await(3, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CyclicBarrier barrier = new CyclicBarrier(3);
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        Semaphore semaphore = new Semaphore(3);
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphore.release();

        Vector<Integer> vector = new Vector<>(100);
        vector.get(1);
        vector.remove(1);
    }

}

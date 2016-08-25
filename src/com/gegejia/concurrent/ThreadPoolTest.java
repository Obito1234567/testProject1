package com.gegejia.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liugaojian on 2016/8/18.
 */
public class ThreadPoolTest {

    public static void main(String[] args)
    {
        testCountDownLatch();
    }

    public static void testCountDownLatch()
    {
        System.out.println("主线程执行中-");
        int count = 3;
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < count; i ++)
        {
            new Thread(new ThreadTask(latch)).start();
        }
        System.out.println("主线程执行中------");
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行结束-----------");
        testFuture();
    }

    public static void testFuture()
    {
        List<FutureTask<Integer>> dataList = new ArrayList<>();
        dataList.add(new FutureTask<Integer>(new Task()));
        dataList.add(new FutureTask<Integer>(new Task()));
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("主线程执行中-");
        for (FutureTask<Integer> ft : dataList)
        {
            executorService.submit(ft);
        }
        System.out.println("主线程执行中--");
        for (FutureTask<Integer> ft : dataList)
        {
            try {
                System.out.println(ft.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线程执行结束");
    }
}

class ThreadTask implements Runnable
{

    private CountDownLatch latch;

    public ThreadTask(CountDownLatch latch)
    {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("son thread " + Thread.currentThread().getName() + " begin---");
        int result = 0;
        for (int i = 0; i < 100; i ++)
        {
            result += i;
        }
        try
        {
            Thread.sleep(3000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("son thread " + Thread.currentThread().getName() + " end--- result = " + result);
        latch.countDown();
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "：子线程正在计算");
        int result = 0;
        for (int i = 0; i < 100; i ++)
        {
            result += i;
        }
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + ":子线程结束");
        return result;
    }
}

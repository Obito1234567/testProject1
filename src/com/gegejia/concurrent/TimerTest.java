package com.gegejia.concurrent;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liugaojian on 2016/8/18.
 */
public class TimerTest {
    public static void main(String[] args)
    {
        Timer timer = new Timer();
        timer.schedule(new TaskTime(), 3000, 1000);
    }

}

class TaskTime extends TimerTask
{

    @Override
    public void run() {
        System.out.println("thread: " + Thread.currentThread().getName() + " is running---");
    }
}


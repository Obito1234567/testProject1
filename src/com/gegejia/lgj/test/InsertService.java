package com.gegejia.lgj.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by liugaojian on 2016/8/11.
 */
public class InsertService {

    public void insertComment()
    {
        int min = 5;
        int max = 15;
        int rand = min + (int) (Math.random() * (max - min));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(new Date());
            }
        }, rand, 6000);
    }
}

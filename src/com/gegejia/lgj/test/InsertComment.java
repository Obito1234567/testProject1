package com.gegejia.lgj.test;

/**
 * Created by liugaojian on 2016/8/11.
 */
public class InsertComment implements Runnable{

    private int rand;

    private volatile boolean flag;

    public void setRand(int rand) {
        this.rand = rand;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                Thread.sleep(rand * 1000);
                System.out.println("插入一条购物信息");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

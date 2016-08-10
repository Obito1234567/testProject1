package com.gegejia.lgj.test;

import java.util.Calendar;

/**
 * @author  liugaojian
 */
public class HelloWorld {
    public static void main(String[] args)
    {
        //zhushi
        System.out.println("hello world"); //dsa
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
        calendar.set(2016, 8, 19, 10, 0, 0);
        System.out.println(System.currentTimeMillis() - calendar.getTimeInMillis());
        System.out.println(Byte.parseByte("1"));
        System.out.println((byte)2);
        System.out.println((byte)CommonEnum.ORDER_STATUS.NOT_DELIVERY.getValue());
        TestHeader hd = new TestHeader();
        System.out.println(hd.getA() + ", b: " + hd.getB());
    }
}

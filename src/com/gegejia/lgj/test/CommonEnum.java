package com.gegejia.lgj.test;

/**
 * Created by liugaojian on 2016/8/9.
 */
public class CommonEnum {
    public static enum ORDER_STATUS
    {
        NOT_PAY(1),
        NOT_DELIVERY(2),
        YES_DELIVERY(3);
        private int value;
        private ORDER_STATUS(int iValue)
        {
            this.value = iValue;
        }
        public int getValue()
        {
            return this.value;
        }
    }
}

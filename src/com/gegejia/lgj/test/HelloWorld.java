package com.gegejia.lgj.test;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.math.BigDecimal;
import java.util.Calendar;

/**
 * @author  liugaojian
 */
public class HelloWorld {
    public static void main(String[] args)
    {
        testIpConvert();
    }

    public static void testIpConvert()
    {
        String ip = "123.563.897.654";
        String ipConvert = ip.replace(".", "_");
        System.out.println(ipConvert);
        System.out.println(ip.replaceAll("\\.", "_"));
    }

    public static void testJson()
    {
        String url = "http://yangege.b0.upaiyun.com/2e4fad5f7463b.jpg#70#98";
        String[] urlAry = url.split("#");
        int index = 0;
        JsonObject bannerImage = new JsonObject();
        bannerImage.addProperty("url", urlAry[index ++]);
        bannerImage.addProperty("height", urlAry[index ++]);
        bannerImage.addProperty("width", urlAry[index ++]);
        JsonObject result = new JsonObject();
        result.addProperty("result", "1");
        result.addProperty("status", "1");
        System.out.println(result.toString());
        result.addProperty("bannerImage", bannerImage.toString());
        System.out.println(result.toString());
        result.add("bannerImage", bannerImage);
        System.out.println(result.toString());
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(result.toString());
        JsonObject banner = object.getAsJsonObject("bannerImage");
        System.out.println(banner.get("url").toString());
        System.out.println(banner.get("url").getAsString());
    }

    public static void chopTest()
    {
        //zhushi
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.SECOND));
        System.out.println(calendar.get(Calendar.MILLISECOND));
        calendar.set(2016, 8, 19, 10, 0, 0);
        System.out.println(calendar.getTime());
        calendar.add(Calendar.DAY_OF_YEAR, 6);
        System.out.println(calendar.getTime());
        System.out.println(calendar.getFirstDayOfWeek());
        System.out.println((byte)CommonEnum.ORDER_STATUS.NOT_DELIVERY.getValue());
        TestHeader hd = new TestHeader();
        System.out.println(hd.getA() + ", b: " + hd.getB());
        int min = 5;
        int max = 15;
        double rd = Math.random();
        System.out.println((int) (rd * (max - min)));
        System.out.println(new BigDecimal(77.56f).setScale(1, BigDecimal.ROUND_HALF_UP));
        String str = "s.s";
    }
}

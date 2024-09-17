package day20_DATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class demo1 {
    public static void main(String[] args) {
        d6();
    }

    private static void d6() {
        // 需求：将 2000-11-11 转换成 2000年11月11日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse("2000-11-11");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
        String s = sdf2.format(date);
        System.out.println(s);

    }

    /**
     * public Date parse(String source)         解析（字符串 -> 日期对象）
     */
    private static void d5() {
        // 1.定义一个字符串表示时间
        String str = "2023-11-12 09:30:11";
        // 2.利用空参构造创建SimpleDateFormat对象
        // 细节：
        // 创建对象的格式要跟字符串的格式完全一致
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // 3.打印结果
        System.out.println(date.getTime()); // 1699752611000
    }

    /**
     * public SimpleDateFormat()                默认格式
     * public SimpleDteFormat(String pattern)   指定格式
     *
     * public final String format(Date date)    格式化（日期对象 -> 字符串）
     */
    private static void d4() {
        // 1.利用空参构造创建SimpleDateFormat对象，默认模式
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date d1 = new Date(0L);
        String str1 = sdf1.format(d1);
        System.out.println(str1);  // 1970/1/1 08:00

        // 2.利用带参构造创建SimpleDateFormat对象，指定格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EE");
        String str2 = sdf2.format(d1);
        System.out.println(str2); // 1970年01月01日 08:00:00 周四
    }

    // 定义任意两个Date对象，比较一下哪个时间在前，哪个时间在后
    private static void d3() {
        Random r = new Random();
        // 创建两个时间对象
        Date d1 = new Date(Math.abs(r.nextInt()));
        Date d2 = new Date(Math.abs(r.nextInt()));
        long time1 = d1.getTime();
        long time2 = d2.getTime();

        if (time1 > time2){
            System.out.println("第一个时间后面，第二个时间在前面");
        } else if(time1 < time2) {
            System.out.println("第二个时间后面，第一个时间在前面");
        } else {
            System.out.println("两个时间一样");
        }
    }

    // 打印时间原点开始一年之后的时间
    private static void d2() {
        // 1.创建一个对象，表示时间原点
        Date d1 = new Date(0L);
        // 2.获取d1时间的毫秒值
        long time = d1.getTime();
        // 3.在这个基础上我们要加一年的毫秒值
        time = time + 1000L * 60 * 60 * 24 * 365;
        // 4.把计算之后的时间毫秒值，再设置回d1当中
        d1.setTime(time);
        // 5.打印d1
        System.out.println(d1);//Fri Jan 01 08:00:00 CST 1971

    }

    /**
     * public Date()            创建Date对象，表示当前时间
     * public Data(long date)   创建Date对象，表示指定时间
     *
     * public void setTime(long time) 设置/修改毫秒值
     * public long getTime()          获取时间对象的毫秒值
     */
    private static void d1() {
        // 1.创建对象表示一个时间
        Date d1 = new Date();
        System.out.println(d1);

        // 2.创建对象表示一个指定时间
        Date d2 = new Date(0L);
        System.out.println(d2);

        // 3.setTime修改时间
        // 1000毫秒 = 1 秒
        d2.setTime(1000L);
        System.out.println(d2);

        // 4.getTime获取当前时间的毫秒值
        long time = d2.getTime();
        System.out.println(time);// 1000
    }
}

package day20_DATE;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * JDK8的时间类：Date
 */

public class demo3 {
    public static void main(String[] args) {
        d3();
    }

    /*
            static ZonedDateTime now() 获取当前时间的ZonedDateTime对象
            static ZonedDateTime ofXxxx(。。。) 获取指定时间的ZonedDateTime对象
            ZonedDateTime withXxx(时间) 修改时间系列的方法
            ZonedDateTime minusXxx(时间) 减少时间系列的方法
            ZonedDateTime plusXxx(时间) 增加时间系列的方法
     */
    private static void d3() {

        //1.获取当前时间对象(带时区)
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);

        //2.获取指定的时间对象(带时区)1/年月日时分秒纳秒方式指定
        ZonedDateTime time1 = ZonedDateTime.of(2023, 10, 1,
                11, 12, 12, 0, ZoneId.of("Asia/Shanghai"));
        System.out.println(time1);

        //通过Instant + 时区的方式指定获取时间对象
        Instant instant = Instant.ofEpochMilli(0L);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime time2 = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(time2);


        //3.withXxx 修改时间系列的方法
        ZonedDateTime time3 = time2.withYear(2000);
        System.out.println(time3);

        //4. 减少时间
        ZonedDateTime time4 = time3.minusYears(1);
        System.out.println(time4);

        //5.增加时间
        ZonedDateTime time5 = time4.plusYears(1);
        System.out.println(time5);

        // 细节：
        // jdk8新增的时间对象都是不可变的
        // 如果我们修改类、减少了、增加了睡觉
        // 那么调用者是不会发生改变的，产生了一个新的时间。
    }

    /**
     * static Instant now()                      获取当前时间的Instant对象(标准时间)
     * static Instant ofXxxx(long epochMilli)    获取一个指定时间戳的Instant对象
     * ZoneDateTime atZone(ZoneId zone)          指定时区
     * boolean isXxxx(Instant otherInstant)      判断系列的方法
     * Instant minusXxxx(long millisToSubtract)  减少时间系列的方法
     * Instant PlusXxxx(long millisToSubtract)  增加时间系列的方法
     */
    private static void d2() {
        // 1.获取当前时间的Instant对象(标准时间)
        Instant now = Instant.now();
        System.out.println(now);

        // 2.根据（秒/毫秒/纳秒）获取Instant对象
        Instant instant1 = Instant.ofEpochMilli(0L);
        System.out.println(instant1);
        System.out.println(Instant.ofEpochSecond(1L));
        System.out.println(Instant.ofEpochSecond(1L,1000000000L));

        // 3.指定时区
        ZonedDateTime zoneSh = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zoneSh);

        // 4.isXxxx 判断
        // isBefore: 判断调用者代表的时间是否在参数表示的时间前面
        // isAfter: 判断调用者代表的时间是否在参数表示的时间后面
        Instant i4 = Instant.ofEpochMilli(0l);
        Instant i5 = Instant.ofEpochMilli(1000l);
        System.out.println(i4.isBefore(i5)); // true
        System.out.println(i5.isAfter(i4)); // true

        // 5.minusXxxx: 减少时间
        Instant i6 = Instant.ofEpochMilli(3000L);
        System.out.println(i6);// 1970-01-01T00:00:03Z
        Instant i7 = i6.minusSeconds(1);
        System.out.println(i7);// 1970-01-01T00:00:02Z
        // 6.plusXxxx: 增加时间
        Instant i8 = i6.plusSeconds(2);
        System.out.println(i8);// 1970-01-01T00:00:05Z

    }

    /**
     * static Set<String> getAvailableZoneIds() 获取Java中支持的所有时区
     * static ZoneId systemDefault()            获取系统默认时区
     * static ZoneId of(String zoneId)          获取一个指定时区
     */
    private static void d1() {
        // 1.获取所有的时区名称
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
//        for (String id : zoneIds) {
//            System.out.println(id);
//        }
//        System.out.println(zoneIds.size());
        // 2.获取当前系统的默认时区
        System.out.println("当前系统的默认时区是：" + ZoneId.systemDefault());

        // 3.获取指定的时区
        System.out.println(ZoneId.of("America/Bogota"));
    }
}

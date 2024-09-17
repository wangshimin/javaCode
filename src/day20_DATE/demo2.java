package day20_DATE;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar常用方法
 *
 * public final Date getTime()              获取日期对象
 * public final setTime(Date date)          给日历设置日期对象
 *
 * public long getTimeMillis()              拿到时间毫秒值
 * public void setTimeMillis(long millis)   给日历设置时间毫秒值
 *
 * public int get(int field)                取日历中的某个字段信息
 * public void set(int field, int value)    修改日历的某个字段信息
 * public void add(int field, int amount)   为某个字段增加/较少指定的值
 *
 * 细节：
 * 1.Calendar是一个抽象类，不能直接new，而是通过一个静态方法获取到子类对象
 * 2.月份：范围是0～11，如获取出来的是0，实际上是1月
 *   星期：周日是一周的第一天
 *
 */
public class demo2 {
    public static void main(String[] args) {
        d1();
    }

    private static void d1() {
        // 1.获取日历对象
        // 底层原理：
        // 会根据系统的不同市区来获取不同的日历对象，默认表示当前时间。
        // 它会把时间中的纪元、年、月、日、时、分、秒、星期、等等都放到一个数组当中
        // 0 : 纪年
        // 1 ： 年
        // 2 ： 月
        // 3 ： 一年中的第几周
        // 4 ： 一个月中的第几周
        // 5:  一个月中的第几天（日期）
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        // 2.修改一下日历代表的时间
        Date d = new Date(0L);
        c.setTime(d);
        System.out.println(c);

        c.set(Calendar.YEAR, 2024);
        c.set(Calendar.MONTH, 8);
        c.set(Calendar.DATE, 17);
        // 增加一个月
        c.add(Calendar.MONTH, 1);
        // 减少两个月
        c.add(Calendar.MONTH, -2);

        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK);
        System.out.println(year + "，"+ month + "，" + date + "，"+getWeek(week));
    }

    /**
     * 传入对应的数字，返回对应的星期
     * @param index
     * @return
     */
    public static String getWeek(int index){
        String[] arr = {"","星期日", "星期一", "星期二", "星期三","星期四","星期五","星期六"};
        return arr[index];
    }
}

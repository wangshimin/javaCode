package day20_Paractive;

import java.time.LocalDate;
import java.util.Calendar;

/**
 * 判断任意的一个年份是闰年还是平年。
 * 要求：用JDK7和JDK8两种方式判断。
 * 提示：二月有29天是闰年，一年有366天是闰年。
 */
public class Test5 {
    public static void main(String[] args) {
        // JDK7
        // 简化1:
        // 我们可以把时间设置为2000年3月1日
        Calendar c = Calendar.getInstance();
        c.set(2000,2,1); // 月份的范围：0～11，写2实际上就是3月
        // 再把日历往前减一天
        c.add(Calendar.DAY_OF_MONTH, -1);
        // 看当前的时间是28号还是29号
        int day1 = c.get(Calendar.DAY_OF_MONTH);
        System.out.println(day1 == 28?"平年":"闰年");

        // JDK8
        // 时间设置为2000年3月1日
        LocalDate ld = LocalDate.of(2000, 3, 1);
        // 把时间往前减一天
        LocalDate ld2 = ld.minusDays(1);
        // 获取这一天是一个月中的几号
        int day2 = ld2.getDayOfMonth();
        System.out.println(day2 == 28?"平年":"闰年");

        // true:闰年 false:平年
        System.out.println(ld.isLeapYear()? "闰年": "平年");
    }
}

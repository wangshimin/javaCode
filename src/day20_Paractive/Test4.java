package day20_Paractive;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * 请使用代码实现计算你活了多少天，用JDK7和JDK8两种方式完成。
 */
public class Test4 {
    public static void main(String[] args) {

        // JDK7
        // 规则：只要对时间进行计算或者判断，都需要先获取当前时间的毫秒值
        // 1.计算出生年与日
        String birthday = "1998年8月8日";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = null;
        try {
            date = sdf.parse(birthday);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        long birthdayTime = date.getTime();
        // 2.获取当前时间的毫秒值
        long todayTime = System.currentTimeMillis();
        // 3.计算间隔时间
        long time = todayTime - birthdayTime;
        System.out.println( time / 1000 / 60 / 60 / 24 );

        // JDK8
        // ChronoUnit
        LocalDate ld1 = LocalDate.of(1998, 8, 8);
        LocalDate ld2 = LocalDate.now();
        long days = ChronoUnit.DAYS.between(ld1, ld2);
        System.out.println(days);
    }
}

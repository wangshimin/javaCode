package day32_Thread.Test4Case2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class MyThread extends Thread{

    // 共享数据：100块，分成了3个包
    // 总金额
    static BigDecimal money = BigDecimal.valueOf(100.0);
    // 红包个数
    static int count = 3;

    // 最小的中奖金额
    static final BigDecimal MIN = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
        // 同步代码块
       synchronized(MyThread.class){
           if (count == 0) {
               // 判断，共享数据是否到了末尾（已经到末尾）
               System.out.println(getName() + "没有抢到红包！");
           } else {
               // 判断，共享数据是否到了末尾（没有到末尾）
               // 定义一个变量，表示中奖的金额
               BigDecimal price;
               if (count == 1) {
                   // 表示此时是最后一个红包
                   // 就无需随机，剩余所有的钱都是中奖金额
                   price = money;
               } else {
                   // 获取抽奖范围
                   double bounds = money.subtract(BigDecimal.valueOf(count - 1).multiply(MIN)).doubleValue();
                   Random r = new Random();
                   // 抽奖金额
                   price = BigDecimal.valueOf(r.nextDouble(bounds));
               }
               // 设置抽中红包（小数点保留两位，四舍五入）
               price = price.setScale(2, RoundingMode.HALF_UP);
               // 在总金额中去掉对应的钱
               money = money.subtract(price);
               // 红包少了一个
               count--;
               // 输出红包信息
               System.out.println(getName() + "抽中了" + price + "元");
           }
       }
    }
}

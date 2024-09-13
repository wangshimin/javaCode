package day18_API.BigDecimal;

import java.math.BigDecimal;

public class demo1 {
    public static void main(String[] args) {
        System.out.println( 0.09 + 0.01 );// 0.09999999999999999
        System.out.println( 0.216 - 0.1 );// 0.11599999999999999
        System.out.println( 0.226 * 0.01 );// 0.0022600000000000003
        System.out.println( 0.09 / 0.1 );// 0.8999999999999999

        // 1.通过传递double类型的小数来创建对象
        // 细节：
        // 这种方式有可能是不精确的，所以不建议使用
        BigDecimal bd1 = new BigDecimal(0.01);
        BigDecimal bd2 = new BigDecimal(0.09);
        System.out.println(bd1); // 0.01000000000000000020816681711721685132943093776702880859375
        System.out.println(bd2); // 0.0899999999999999966693309261245303787291049957275390625

        // 2.通过传递字符串表示的小数来创建对象
        BigDecimal bd3 = new BigDecimal("0.01"); // 0.01
        BigDecimal bd4 = new BigDecimal("0.09"); // 0.09
        BigDecimal bd5 = bd3.add(bd4);
        System.out.println(bd3); // 0.01
        System.out.println(bd4); // 0.09
        System.out.println(bd5); // 0.10

        // 3.通过静态方法获取对象
        BigDecimal bd6 = BigDecimal.valueOf(10);
        BigDecimal bd7 = BigDecimal.valueOf(10);
        System.out.println(bd6);// 10
        System.out.println(bd6 == bd7);// true
        System.out.println(BigDecimal.valueOf(10.0) == BigDecimal.valueOf(10.0));// false


        // 细节：
        // 1.如果要表示的数字不大，没有超出double的取值范围，建议使用静态方法
        // 2.如果要表示的数字比较大，超出了double的取值范围，建议使用构造方法
        // 3.如果我们传递的是0～10之间的整数，包含0、10，那么方法会返回已经创建好的对象，不会重新new 一个对象

    }
}

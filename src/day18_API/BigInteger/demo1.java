package day18_API.BigInteger;

import java.math.BigInteger;
import java.util.Random;

public class demo1 {
    public static void main(String[] args) {
        /**
         * public BigInteger(int num, Random rnd)   获取随机大整数，范围：[0 ~ 2的num次方-1]
         * public BingInteger(String val)           获取指定的大整数
         * public BigInteger(String val, int radix) 获取指定进制的大整数
         *
         * public static BigInteger valueOf(long val) 静态方法获取BigInteger的对象，内部有优化
         * 细节：
         *      对象一旦创建，里面的数据不能发生改变。
         */

        // 1.获取一个随机的大整数
        /* Random r = new Random();
        for (int i = 0; i < 100; i++) {
            BigInteger bd1 = new BigInteger(4, r);
            System.out.println(bd1); // [0 ~ 15]
        } */

        // 2.获取指定的大整数
        // 细节：字符串中必须是整数，否则会报错
        BigInteger bd2 = new BigInteger("9999999999999999");
        System.out.println(bd2);

        // 3.获取指定进制的大整数
        // 细节：字符串中的数字必须是整数、必须要跟进制吻合（二进制中只能写0和1，写其他就报错）。
        BigInteger bd3 = new BigInteger("100", 8); // 获取八进制的100
        System.out.println(bd3);

        // 4.静态方法获取BigInteger的对象，内部有优化
        // 细节：
        // 1.能表示范围比较小，在long的取之范围之内，如果超出long的范围就报错。
        // 2.在内部对常用的数字： -16 ～ 16 进行了优化。
        //   提前把-16 ～16 先创建好BigInteger对象，以后直接返回，不用每次都创建。
        BigInteger bd4 = BigInteger.valueOf(1234);
        System.out.println(bd4);
        System.out.println(BigInteger.valueOf(16) == BigInteger.valueOf(16));
        System.out.println(BigInteger.valueOf(17) == BigInteger.valueOf(18));

         // 5.对象一旦创建，内部的数据不能改变
        BigInteger bd9 = BigInteger.valueOf(1);
        BigInteger bd10 = BigInteger.valueOf(2);
        BigInteger result = bd9.add(bd10);
        System.out.println(result); // 3
        // 此时不会改变bd9和bd10的值，而是创建了一个新的对象，3
        System.out.println(bd9 == result);  // false
        System.out.println(bd10 == result); // false

    }
}

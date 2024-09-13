package day18_API.BigInteger;

import java.math.BigInteger;

public class demo2 {
    public static void main(String[] args) {
        /**
         * public BigInteger add(BigInteger val)        加法
         * public BigInteger subtract(BigInteger val)   减法
         * public BigInteger multiply(BigInteger val)   乘法
         * public BigInteger divide(BigInteger val)     除法，获取商
         * public BigInteger divideAndRemainder(BigInteger val)  除法，获取商和余数
         * public boolean equals(Object x)              比较是否相同
         * public BigInteger pow(int exponent)          次幂
         * public BigInteger max/min(BigInteger val)    返回较大值/较小值
         * public int intValue(BigInteger val)          转为int类型整数，超出范围数据有误
         */

        // 1.创建两个BigInteger对象
        BigInteger bd1 = BigInteger.valueOf(10);
        BigInteger bd2 = BigInteger.valueOf(5);

        // 2.加法
        BigInteger bd3 = bd1.add(bd2);
        System.out.println(bd3); // 15

        // 3.除法，获取商和余数
        BigInteger[] arr = bd1.divideAndRemainder(BigInteger.valueOf(6));
        System.out.println(arr.length);
        System.out.println(arr[0]); // 商
        System.out.println(arr[1]); // 余数

        // 4.比较是否相同
        System.out.println(bd1.equals(bd2)); // false
        System.out.println(bd1.equals(BigInteger.valueOf(10))); // true

        // 5.次幂
        System.out.println(bd1.pow(3)); // 10的3次方，1000

        // 6.返回较大值/较小值
        System.out.println(bd1.max(bd2)); // 10
        System.out.println(bd1.min(bd2)); // 5

        // 7.转为int类型整数，超出范围数据有误
        BigInteger bd4 = BigInteger.valueOf(2147483648L);
        int i = bd4.intValue();
        System.out.println(i); // 数据有误

        System.out.println(new BigInteger("200").doubleValue()); // 200.0

    }
}

package day18_API;

public class MathDemo {
    public static void main(String[] args) {
        // abs 获取参数绝对值
        System.out.println(Math.abs(88));
        System.out.println(Math.abs(-88));
        // bug:
        // 以int类型为例，取值范围：-2147483648 ~ 2147483647
        // 如果没有正数与负数对应，那么传递负数结果有误
        System.out.println(Math.abs(-2147483648)); // 没有正数与之对应。所以会产生bug
        System.out.println(Math.abs(-2147483647)); // 2147483647

//        System.out.println(Math.absExact(-2147483648));


        // ceil 向上取整，进一法，向正无穷大方向获取距离最近的整数
        System.out.println(Math.ceil(5.12));// 6.0
        System.out.println(Math.ceil(-5.132)); // -5.0


        // floor 向下取整，去尾法，向负无穷大方向获取距离最进的整数
        System.out.println(Math.floor(5.12));// 5.0
        System.out.println(Math.floor(-5.132)); // -6.0

        // round 四舍五入
        System.out.println(Math.round(12.34)); // 12
        System.out.println(Math.round(12.54)); // 13
        System.out.println(Math.round(-12.34));// -12
        System.out.println(Math.round(-12.54));// -13

        System.out.println("-------------------------");
        // max 获取两个整数的最大值
        System.out.println(Math.max(12, 34)); // 34
        System.out.println(Math.max(-12, -34)); // -12
        // min 获取两个整数的最小值
        System.out.println(Math.min(12, 34)); // 12
        System.out.println(Math.min(-12, -34)); // -34

        System.out.println("-------------------------");

        // pow(double a, double b) 返回a的b次幂的值
        System.out.println(Math.pow(2,3));  // 8.0
        System.out.println(Math.pow(2, 8)); // 256.0
        // 细节：
        // 如果第二个参数 0～1之间的小数
        System.out.println(Math.pow(4, 0.5)); // 2.0
        System.out.println(Math.pow(2, -2));  // 0.25
        // 建议：
        // 第二个参数：一般传递大于等于1的正整数。
        // sqrt(double a) 返回a的平方根
        System.out.println(Math.sqrt(4)); // 2.0
        // cbrt(double a) 返回a的立方根
        System.out.println(Math.cbrt(8)); // 2.0

        System.out.println("-------------------------");
        // 随机数 0 ~ 100
         for (int i = 0; i < 10; i++) {
            System.out.println(Math.floor(Math.random()*100) + 1);
        }



    }
}

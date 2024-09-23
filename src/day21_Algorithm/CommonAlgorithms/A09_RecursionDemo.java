package day21_Algorithm.CommonAlgorithms;

/**
 * 递归算法
 */
public class A09_RecursionDemo {
    public static void   main(String[] args) {
        /* d1(); */
        d2();
    }

    /**
     * 递归求阶乘
     *
     * 需求：用递归求5的阶乘，并把结果在控制台输出
     * 5！= 5 * 4 * 3 * 2 * 1
     * 100！= 100 * 99 * 98 * 97 * ... * 2 * 1
     *
     * 5! = 5 * 4!;
     * 4! = 4 * 3!;
     * 3! = 3 * 2!;
     * 2! = 2 * 1!;
     * 1! = 1;
     */
    private static void d2() {
        System.out.println(getFactorial(5));// 120
    }

    private static int getFactorial(int num) {
        if (num == 1){
            return 1;
        }

        return num * getFactorial(num - 1);
    }

    // 需求：利用递归求1-100之间的和
    private static void d1() {
//        100 + 99 + 98 + 97 + 96 + 95 + ... + 2 + 1

        // 大问题拆解成小问题
        // 1～100之间的和 = 100 +（1～99之间的和）
        // 1～99之间的和 = 99 +（1～98之间的和）
        // 1～98之间的和 = 98 +（1～97之间的和）
        // 。。。
        // 1～2之间的和 = 2 +（1～1之间的和）
        // 1～1之间的和 = 1（递归的出口）

        System.out.println(getSum(100));// 5050
    }


    private static int getSum(int number) {
        if (number == 1){
            return 1;
        }
        return number + getSum(number - 1);
    }
}

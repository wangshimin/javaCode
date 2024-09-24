package day21_Algorithm.Lambda.Test;

public class Test4 {
    public static void main(String[] args) {
        /**
         * 需求
         * ：可爱的小明特别喜欢爬楼梯，他有时候一次爬一个台阶，有的时候一次爬两个台阶。
         * 如果这个楼梯有20个台阶，他一共有多少种爬法呢？
         *
         * 运算结果：
         * 1层台阶 1种爬法
         * 2层台阶 2种爬法
         * 3层台阶 3种爬法
         * 4层台阶 5种爬法
         * 5层台阶 8种爬法
         * 6层台阶 13种爬法
         * 7层台阶 21种爬法
         */
        System.out.println(getCount(20));// 10946
    }

    private static int getCount(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return getCount(n - 1) + getCount(n - 2);
    }
}

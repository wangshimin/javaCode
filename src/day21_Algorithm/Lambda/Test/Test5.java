package day21_Algorithm.Lambda.Test;

public class Test5 {
    public static void main(String[] args) {
        /**
         * 需求
         * ：可爱的小明特别喜欢爬楼梯，他有时候一次爬一个台阶，有的时候一次爬两个台阶，有的时候一次爬三 个台阶。
         * 如果这个楼梯有20个台阶，他一共有多少种爬法呢？
         *
         * 运算结果：
         * 1层台阶 1种爬法
         * 2层台阶 2种爬法
         * 3层台阶 4种爬法
         * 4层台阶 7种爬法
         * 5层台阶 13种爬法
         * 6层台阶 24种爬法
         * 7层台阶 44种爬法
         */
        System.out.println(getCount(20));// 121415
    }

    private static int getCount(int n) {
        if (n <= 2) return n;
        if ( n == 3) return 4;

        return getCount(n - 1) + getCount(n - 2) + getCount(n -3);
    }
}

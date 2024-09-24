package day21_Algorithm.Lambda.Test;

public class Test3 {
    public static void main(String[] args) {
        /**
         * 需求：
         * 有一堆桃子，猴子第一天吃了其中的一半，并多吃了一个。
         * 以后每天猴子都吃当前剩下来的一半，然后再多吃一个，
         * 第10天的时候（还没吃），发现只剩下一个桃子了，请问最初总共多少个桃子？
         *
         * day10 : 1
         * day9  : (day10 + 1) * 2 = 4
         * day8  : (day9 + 1) * 2 = 10
         * day7  : (day8 + 1) * 2 = 22
         * 每一天的桃子数量都是后一天的数量+1 再乘以2
         *
         *
         * 1.递归出口：
         *           day == 10 ， 剩下1
         * 2. 递归规律：
         *          每一天的数量都是后一天数量+1再乘以2
         */
        int sum = 1;
        for (int i = 2; i <= 10; i++) {
            sum = ( sum + 1 ) * 2;
        }
        System.out.println(sum);


        System.out.println(getCount(1));
    }

    public static int getCount(int day){
         if (day <= 0 || day >= 11) {
             System.out.println("当前时间有误");
             return -1;
         }
         // 递归的出口
        if (day == 10)  return 1;

        // 书写规律
        return (getCount(day + 1) +1 ) * 2;
    }
}

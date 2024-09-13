package day18_API;

public class SystemDemo {
    public static void main(String[] args) {
        /**
         * public static void exit(int status) 终止当前运行的 Java 虚拟机
         * public static long currentTimeMillis() 返回以毫秒为单位的当前时间
         * public static void arraycopy(数据源数组, 起始索引, 目的地数组, 起始索引, 拷贝个数)  数组拷贝
         */

        // 方法的形参：
        // 状态码：
        // 0 - 表示当前虚拟机是正常停止
        // 非0 - 表示当前虚拟机异常停止
//        System.exit(0);
//        System.out.print("看看我执行了吗");
        // 以拼图小游戏为例，当我们需要把整个程序结束的时候，就可以调用这个方法。

        long l = System.currentTimeMillis();
        System.out.println(l);

        // 拷贝数组
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr2 = new int[10];

        // 把arr1数组中的数据拷贝至arr2中
        // 参数一：数据源，要拷贝的数据从哪个数组而来
        // 参数二：从数据源数组中的第几个索引开始拷贝
        // 参数三：目的地，把拷贝的数据放到哪个数组中
        // 参数四：从目的地数组的第几个索引开始拷贝
        // 参数五：拷贝多少个数据
        System.arraycopy(arr1, 3, arr2, 3, 5);
        // 验证
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }


    }
}

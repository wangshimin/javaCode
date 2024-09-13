package day18_API;

import java.io.IOException;

public class RuntimeDemo {
    public static void main(String[] args) {
        /**
         * public static  Runtiome getRuntime()  返回当前系统的运行环境对象
         * public void    exit(int status)       终止当前运行的 Java 虚拟机
         * public int     availableProcessors（） 返回可用的处理器数量；获得CPU的线程数
         * public long    maxMemory()            返回 Java 虚拟机中的最大内存量，以字节为单位;JVM能从系统中获取总内存大小（单位byte）
         * public long    totalMemory()          返回 Java 虚拟机中的内存总量，以字节为单位;JVM已经从系统中获取的总内存大小（单位byte）
         * public long    freeMemory()           返回 Java 虚拟机中的剩余内存量，以字节为单位;JVM剩余内存大小（单位byte）
         * public Process exec(String command)   运行cmd命令
         */

        // 1.获取Runtime的对象
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();
        System.out.println(r1 == r2); // true，说明两次获取到的是一个对象。

        // 2.exit 停止虚拟机
//        Runtime.getRuntime().exit(0);
//        System.out.println("看看我执行了吗");

        // 3.获得CPU的线程数
        System.out.println(Runtime.getRuntime().availableProcessors()); // 16

        // 4.maxMemory 总内存大小，单位byte字节
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 +"M");// 4096M

        // 5.totalMemory 已经获取的总内存大小，单位byte字节
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024 +"M");// 256M

        // freeMemory 剩余内存大小，单位byte字节
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024 +"M");// 254M

        // 7.运行cmd命令
        try {
            // 打开Docker
            Runtime.getRuntime().exec("open /applications/Docker.app");

             // shutdown:关机
            // 加上参数才能执行
            // -s :默认1分钟之后关机
            // -s -t 指定时间：指定关机时间
            // -a: 取消关机操作
            // -r: 关机并重启


//            // 开启定时关机，60秒后关机
//            Runtime.getRuntime().exec("shutdown -s -t 60");
//            // 关闭定时关机
//            Runtime.getRuntime().exec("shutdown -a");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

package day32_Thread.Thread_Pool.Demo1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demo {
    /*
    public static ExecutorService newCachedThreadPool()             创建一个没有上限的线程池
    public static ExecutorService newFixedThreadPool (int nThreads) 创建有上限的线程池
    */
    public static void main(String[] args) {

        // 1.获取线程池对象
        ExecutorService pool1 = Executors.newFixedThreadPool(3);
        // 2.提交任务
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());
        pool1.submit(new MyRunnable());

        // 3.销毁线程池
        pool1.shutdown();

    }
}

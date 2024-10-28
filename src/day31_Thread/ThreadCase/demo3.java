package day31_Thread.ThreadCase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class demo3 {
    /*
    *   多线程的第三种实现方式：
    *       特点：可以获取到多线程运行的结果
    *
    *       1. 创建一个类MyCallable实现Callable接口
    *       2. 重写call （是有返回值的，表示多线程运行的结果）
    *
    *       3. 创建MyCallable的对象（表示多线程要执行的任务）
    *       4. 创建FutureTask的对象（作用管理多线程运行的结果）
    *       5. 创建Thread类的对象，并启动（表示线程）
    * */
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //创建MyCallable的对象（表示多线程要执行的任务)
        //线程开启之后需要执行里面的call方法
        MyCallable mc = new MyCallable();
        // 创建FutureTask的对象（作用管理多线程运行的结果）
        //可以获取线程执行完毕之后的结果.也可以作为参数传递给Thread对象
        FutureTask<Integer> ft = new FutureTask<>(mc);
        // 创建Thread类的对象（表示线程）
        Thread t1 = new Thread(ft);
        // 并启动
        t1.start();

        // 获取多线程运行的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}

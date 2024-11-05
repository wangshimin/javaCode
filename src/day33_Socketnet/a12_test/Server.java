package day33_Socketnet.a12_test;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    /*
    需求：上传文件（线程池优化）
    频繁创建线程并销毁非常浪费系统资源，所以需要用线程池优化
     */
    public static void main(String[] args) throws IOException {

        // 创建线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,  // 核心线程数量
                16,             // 线程池总大小
                60,             // 空闲时间
                TimeUnit.SECONDS,// 空闲时间（单位）
                new ArrayBlockingQueue<>(2),// 队列
                Executors.defaultThreadFactory(),   // 线程工厂，让线程池如何创建线程对象
                new ThreadPoolExecutor.AbortPolicy()// 阻塞队列
        );

        // 1.创建对象并绑定端口
        ServerSocket serverSocket = new ServerSocket(10012);

        while (true) {
            // 2.等待客户端来连接
            System.out.println("等待客户端连接...");
            Socket socket = serverSocket.accept();
            System.out.println("客户端连接成功");

            // 开启一条线程
            // 一个客户端就对应服务端的一条线程
//            new Thread(new MyRunnable(socket)).start();
            pool.submit(new MyRunnable(socket));
        }

    }
}

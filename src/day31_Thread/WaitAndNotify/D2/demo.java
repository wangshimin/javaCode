package day31_Thread.WaitAndNotify.D2;

import java.util.concurrent.ArrayBlockingQueue;

public class demo {
    public static void main(String[] args) {
        /*
         *
         *    需求：利用阻塞队列完成生产者和消费者（等待唤醒机制）的代码
         *    细节：
         *           生产者和消费者必须使用同一个阻塞队列
         *
         * */

        // 1.创建阻塞队列的对象
        ArrayBlockingQueue<String> queque = new ArrayBlockingQueue<>(1);

        // 2.创建线程的对象，并把阻塞队列传递过去
        Cook c = new Cook(queque);
        Foodie f = new Foodie(queque);

        // 3.开启线程
        c.start();
        f.start();
    }
}

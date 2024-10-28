package day31_Thread.ThreadSafe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class demo3 {
    /*
           需求：
                某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
                用JDK5的lock实现
       */
    public static void main(String[] args) {
        // 创建线程对象
        MyThead3 t1 = new MyThead3();
        MyThead3 t2 = new MyThead3();
        MyThead3 t3 = new MyThead3();

        // 起名字
        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        // 开启线程
        t1.start();
        t2.start();
        t3.start();
    }
}

class MyThead3 extends Thread{

    static int ticket = 0;

    static Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // 循环
        while (true){
            // 2.同步代码块
//            synchronized(MyThead3.class){
            lock.lock();
                // 3.判断
            try {
                if (ticket == 100){
                    break;
                    // 判断
                } else {
                    Thread.sleep(10);
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
//            }
        }
    }
}

package day31_Thread.ThreadMethod;

public class demo3 {
    /*
            final void setDaemon(boolean on)    设置为守护线程
            细节：
                当其他的非守护线程执行完毕之后，守护线程会陆续结束
            通俗易懂：
                当女神线程结束了，那么备胎也没有存在的必要了
       */
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();

        t1.setName("女神");
        t2.setName("备胎");

        //把第二个线程设置为守护线程（备胎线程）
        //当普通线程执行完之后,那么守护线程也没有继续运行下去的必要了
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + " @ " + i);
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " -- " + i);
        }
    }
}
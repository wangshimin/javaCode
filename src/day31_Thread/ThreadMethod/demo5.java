package day31_Thread.ThreadMethod;

public class demo5 {
    /*
            public static void yield()      出让线程/礼让线程

       */

    public static void main(String[] args) {
        MyThread5 t1 = new MyThread5();
        MyThread5 t2 = new MyThread5();

        t1.setName("飞机");
        t2.setName("坦克");

        t1.start();
        t2.start();
    }
}

class MyThread5 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {

            System.out.println(getName() + "@" + i);
            //表示出让当前CPU的执行权
            Thread.yield();
        }
    }
}

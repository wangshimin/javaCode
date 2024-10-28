package day31_Thread.ThreadMethod;

public class demo2  {
    /*
            setPriority(int newPriority)        设置线程的优先级
            final int getPriority()             获取线程的优先级
       */
    public static void main(String[] args) {
        // 创建线程要执行的参数对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象
        Thread t1 = new Thread(mr, "飞机");
        Thread t2 = new Thread(mr,"高铁");

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getPriority());

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }
}

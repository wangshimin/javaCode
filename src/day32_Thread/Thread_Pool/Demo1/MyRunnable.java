package day32_Thread.Thread_Pool.Demo1;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + "----" + i);
        }

    }
}

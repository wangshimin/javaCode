package day31_Thread.ThreadMethod;

public class demo6 {
    /*
            public final void join()  插入线程/插队线程
       */
    public static void main(String[] args) throws InterruptedException {

        System.out.println("hahah");
        MyThread6 t = new MyThread6();
        t.setName("土豆");
        t.start();

        //表示把t这个线程，插入到当前线程之前。
        //t:土豆
        //当前线程: main线程
        t.join();

        //执行在main线程当中的
        for (int i = 0; i < 10; i++) {
            System.out.println("main线程 - "+ i);
        }


    }

}

class MyThread6 extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
        }
    }
}

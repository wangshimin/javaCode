package day31_Thread.ThreadSafe;

public class demo1 {
    /*
           需求：
                某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票
       */
    public static void main(String[] args) {

        // 创建线程对象
        MyThead1 t1 = new MyThead1();
        MyThead1 t2 = new MyThead1();
        MyThead1 t3 = new MyThead1();

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

class MyThead1 extends Thread{

    // 表示这个类所有的对象，都共享ticket数据
    static int ticket = 0; // 0 ~ 99


    @Override
    public void run() {
        while (true) {
            // 同步代码块
            synchronized ( MyThead1.class ){
                if (ticket < 100){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    ticket++;
                    System.out.println(getName() + "正在卖第" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}

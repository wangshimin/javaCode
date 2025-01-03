package day32_Thread.Test2;

public class Test {
    /*
            有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，
            利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来.
        */


    public static void main(String[] args) {
        //  创建参数对象
        MyRunable mr = new MyRunable();
        // 创建线程对象
        Thread t1 = new Thread(mr, "窗口1");
        Thread t2 = new Thread(mr, "窗口2");
        // 启动线程
        t1.start();
        t2.start();
    }
}

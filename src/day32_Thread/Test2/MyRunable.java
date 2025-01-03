package day32_Thread.Test2;

public class MyRunable implements Runnable{

    //第二种方式实现多线程，测试类中MyRunable只创建一次，所以不需要加static
    int count = 100;
    @Override
    public void run() {
        // 1.循环
        while (true){
            // 2.同步代码块
            synchronized(MyRunable.class){
                // 3.判断共享数据（已经到末尾）
                if (count < 10) {
                    System.out.println("礼物还剩下" + count + "份，不再赠送");
                    break;
                } else {
                    // 4.判断共享数据（没有到末尾）
                    count--;
                    System.out.println(Thread.currentThread().getName() + "在赠送礼物，还剩下" + count + "份礼物！");
                }
            }
        }
    }
}

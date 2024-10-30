package day32_Thread.Test5;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        // 1.循环
        while (true){
            // 2.同步代码块
            synchronized (MyThread.class) {
                // 3.已到末尾
                if (list.size() == 0) {
                    break;
                } else {
                    // 4.未到末尾，继续抽奖
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    System.out.println(getName() + "又产生了一个 " + price + " 元大奖");
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

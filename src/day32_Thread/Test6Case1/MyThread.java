package day32_Thread.Test6Case1;

import java.util.ArrayList;
import java.util.Collections;

public class MyThread extends Thread{
    ArrayList<Integer> list;

    public MyThread(ArrayList<Integer> list) {
        this.list = list;
    }

    // 线程一
    static ArrayList<Integer> list1 = new ArrayList<>();
    // 线程二
    static ArrayList<Integer> list2 = new ArrayList<>();

    @Override
    public void run() {
        while (true){
            synchronized (MyThread.class) {
                boolean IsBox1 = "抽奖箱1".equals(getName());
                if ( list.size() == 0 ) {
                    System.out.print(getName()  + "：");
                    String[] a = (IsBox1 ? list1 : list2).stream().map(String::valueOf).toArray(String[]::new);
                    System.out.print(String.join("，", a)+" 最高奖项为" + Collections.max(IsBox1 ? list1 : list2));
                    System.out.println();
                    break;
                } else {
                    // 继续抽奖
                    Collections.shuffle(list);
                    int price = list.remove(0);
                    if (IsBox1){
                        list1.add(price);
                    } else {
                        list2.add(price);
                    }
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

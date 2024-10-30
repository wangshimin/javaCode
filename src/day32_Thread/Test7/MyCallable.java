package day32_Thread.Test7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Callable;

public class MyCallable implements Callable {

    ArrayList<Integer> list;

    public MyCallable(ArrayList<Integer> list) {
        this.list = list;
    }

    @Override
    public Object call() throws Exception {
        ArrayList<Integer> boxList = new ArrayList<>();
        while (true) {
            synchronized (MyCallable.class) {
                if ( list.size() == 0 ){
                    System.out.println(Thread.currentThread().getName() + boxList);
                    break;
                } else {
                    // 继续抽奖
                    Collections.shuffle(list);
                    Integer price = list.remove(0);
                    boxList.add(price);
                }
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 把集合中的最大值返回
        if (boxList.size() == 0) {
            return null;
        } else {
            return Collections.max(boxList);
        }
    }
}

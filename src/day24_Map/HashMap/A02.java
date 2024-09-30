package day24_Map.HashMap;

import java.util.*;

public class A02 {
    public static void main(String[] args) {
        /*
            某个班级80名学生，现在需要组成秋游活动，
            班长提供了四个景点依次是（A、B、C、D）,
            每个学生只能选择一个景点，请统计出最终哪个景点想去的人数最多。
        */
        //1. 需要先让同学们投票
        //定义一个数组，存储4个景点
        String[] arr = {"A", "B", "C", "D"};
        //利用随机数模拟80个同学的投票，并把投票的结果存储起来
        ArrayList<String> list = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            int index = r.nextInt(arr.length);
            list.add(arr[index]);
        }
        //2. 统计每个景点想去的人数
        HashMap<String, Integer> hm = new HashMap<>();
        for (String name : list) {
            //判断当前景点是否已经存在
            if (hm.containsKey(name)){
                //存在
                // 先获取当前景点已经被投票的次数
                Integer count = hm.get(name);
                // 表示当前景点又被投了一次
                count++;
                // 把新的次数再次添加到集合当中
                hm.put(name, count);
            } else {
                //不存在，则把当前景点对应的值设置为1
                hm.put(name,1);
            }
        }
        System.out.println(hm);
        // 3. 求最大值
        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count > max){
                max = count;
            }
        }
//        System.out.println(max);
        // 4.哪个景点的次数跟最大值一样，则打印出来
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if (count == max){
                System.out.println(entry.getKey());
            }
        }
    }
}

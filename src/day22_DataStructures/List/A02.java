package day22_DataStructures.List;

import java.util.ArrayList;
import java.util.List;

public class A02 {
    public static void main(String[] args) {
        // List系列集合中的两个删除的方法
        // 1.直接删除元素
        // 2.通过索引进行删除

        // 1.创建集合并添加元素
        List<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // 2.删除元素
        // 在调用方法的时候，如果方法出现了重载现象
        // 优先调用，实参跟形参类型一致的那个方法
        list.remove(1);

        // 手动装箱，手动把基本数据类型的40，变成Integer类型
        Integer i = Integer.valueOf(40);
        list.remove(i);
        System.out.println(list); // [10, 30]
    }
}

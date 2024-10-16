package day26_Stream.Immutable;

import java.util.Iterator;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
        /**
         * 创建不可变的List集合
         */
        // 一旦创建不可变的集合，就不能再往集合中添加元素了，只能进行查询操作
        List<String> list = List.of("张三", "李四", "王五", "赵六");

        System.out.println(list.getFirst());
        System.out.println(list.get(2));

        System.out.println("------- 迭代器遍历----------");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }

        System.out.println("------- 增强For遍历----------");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("------- Lambda遍历----------");
        list.forEach(s1 -> System.out.println(s1));

    }
}

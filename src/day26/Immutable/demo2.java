package day26.Immutable;

import java.util.Iterator;
import java.util.Set;

public class demo2 {
    public static void main(String[] args) {
        /**
         * 创建不可变的Set集合
         *
         * 细节：
         * Set集合中的元素是唯一的，不能重复
         */
        Set<String> set = Set.of("张三","李四", "王五", "赵六");
        System.out.println("------- 迭代器遍历----------");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String item = it.next();
            System.out.println(item);
        }

        System.out.println("------- 增强For遍历----------");
        for (String s : set) {
            System.out.println(s);
        }

        System.out.println("------- Lambda遍历----------");
        set.forEach(s1 -> System.out.println(s1));

    }
}

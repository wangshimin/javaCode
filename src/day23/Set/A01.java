package day23.Set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*
利用Set系列的集合，添加字符串，并使用多种方式遍历。
    迭代器
    增强for
    Lambda表达式

 */
public class A01 {
    public static void main(String[] args) {
        // 1.创建一个Set集合对象
        Set<String> s = new HashSet<>();

        // 2.添加元素
        // 如果当前元素是第一次添加，那么可以添加，返回true;
        // 如果当前元素是第二次添加，那么添加失败，返回false.
        boolean r1 = s.add("张三");
        boolean r2 = s.add("张三");
        System.out.println(r1); // true
        System.out.println(r2); // false
        System.out.println(s);  // [张三]

        s.add("李四");
        s.add("王五");
        // 3.打印集合
        System.out.println(s);// [李四, 张三, 王五]

        System.out.println("迭代器遍历");
        Iterator<String> it = s.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        System.out.println("增强for遍历");
        for (String s1 : s) {
            System.out.println(s1);
        }

        System.out.println("Lambda表达式遍历");
        s.forEach(s2-> System.out.println(s2));
    }
}

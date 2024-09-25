package day23.Generics;

import java.util.Arrays;

public class A04 {
    public static void main(String[] args) {
        /**
         * 泛型接口的两种使用方式：
         *      1.实现类给出具体的类型
         *      2.实现类延续泛型，创建实现类对象时再确定类型
         */

        MyArrayList2 list = new MyArrayList2();
        list.add("hello");
        list.add("world");


        MyArrayList3<Integer> list2 = new MyArrayList3<>();
        list2.add(123);
        list2.add(456);
        System.out.println(list2);
    }
}

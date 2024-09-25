package day22_DataStructures.Collection;

import java.util.ArrayList;
import java.util.function.Consumer;

public class A05 {
    public static void main(String[] args) {
        // 创建一个ArrayList并添加一些元素
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("apple");
        list.add("orange");

        // 使用匿名内部类的形式
        System.out.println("使用匿名内部类的形式遍历");
        // 底层原理：
        // 其实也会自己遍历集合，依次得到每一个元素。
        // 把得到的元素作为参数，调用Consumer接口中的accept方法
        list.forEach(new Consumer<String>() {
            @Override
            // s依次表示集合中的每一个数据
            public void accept(String s) {
                System.out.println(s);
            }
        });

        // 使用Lambda表达式遍历集合
        System.out.println("使用Lambda表达式遍历集合");
        // forEach 方法接受一个 Consumer 函数式接口作为参数，这里使用 Lambda 表达式 item -> System.out.println(item) 来遍历并打印集合中的每个元素。
        list.forEach(s -> System.out.println(s));

        // 使用Lambda表达式删除所有"apple"（不推荐直接在集合上操作）
        System.out.println("\nAttempting to remove all 'apple' elements using Lambda:");
        try {
            //  forEach 方法内部使用了迭代器来遍历集合，而直接修改集合会导致迭代器失效。
            list.forEach(item -> {
                if ("apple".equals(item)) {
                    list.remove(item); // 不推荐这样做，会导致ConcurrentModificationException
                }
            });
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e.getMessage());
        }

        // 正确的方法是使用removeIf方法删除元素
        System.out.println("\nCorrectly removing all 'apple' elements using removeIf:");
        //  removeIf 方法是一个更安全的选择，它接受一个 Predicate 函数式接口作为参数，用于判断哪些元素需要被删除。这里使用 Lambda 表达式 item -> "apple".equals(item) 来指定需要删除的元素。
        list.removeIf(item -> "apple".equals(item));

        // 再次遍历集合查看结果
        System.out.println("\nList after removing 'apple':");
        list.forEach(System.out::println);
    }
}

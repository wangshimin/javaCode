package day22_DataStructures.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Collection系列集合三种通用的遍历方式
 * 1.迭代器遍历
 * 2.增强for遍历
 * 3.Lambda表达式遍历
 *
 * 增强for遍历 格式：
 * for(数据类型 变量名 : 集合/数组) {
 *
 * }
 *
 * 增强 for 循环是一种简化集合遍历的方式，但它不适合在遍历过程中直接修改集合。
 * 如果需要在遍历过程中修改集合，应该使用迭代器，并且使用迭代器的 remove() 方法来删除元素。
 * 这样可以避免 ConcurrentModificationException 异常，并确保遍历过程的安全性和正确性。
 */
public class A04 {
    public static void main(String[] args) {
        // 1.创建集合并添加元素
        Collection<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("apple");
        list.add("orange");

        // 使用增强for循环遍历集合
        System.out.println("Original list:");
        // 注意点：
        // s其实就是一个第三方变量，在循环的过程中依次表示集合中的每一个数据
        // 修改增强for中的变量，不会改变集合中原本的数据。
        for (String s : list) {
            s = "qqq";
            System.out.println(s);
        }
        System.out.println(list);// [apple, banana, cherry, apple, orange]

        System.out.println("使用迭代器删除元素");
        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            String item = it.next();
            if ("apple".equals(item)){
                it.remove();
            }
        }

        // 再次遍历集合查看结果
        System.out.println("\nList after removing 'apple':");
        for (String item : list) {
            System.out.println(item);
        }

    }
}

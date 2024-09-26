package day23.Set.HashSet.LinkedHashSet;

import day23.Set.HashSet.Student;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet
 * 1.特点：有序、不重复、无索引
 * 2.原理：底层给予哈希表，使用双链表添加顺序
 * 3.如果数据要去重，默认使用HashSet，如果要求去重且存储有序，可使用LinkedHashSet
 */
public class A01 {
    public static void main(String[] args) {
        // 1.创建4个学生对象
        Student s1 = new Student("zhangsan", 18);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);
        Student s4 = new Student("zhangsan", 18);

        // 2.创建集合的对象
        LinkedHashSet<Student> lhs = new LinkedHashSet<>();

        // 3.添加元素
        System.out.println(lhs.add(s3)); // true
        System.out.println(lhs.add(s2)); // true
        System.out.println(lhs.add(s1)); // true
        System.out.println(lhs.add(s4)); // false

        // 4.打印集合
        System.out.println(lhs); // [Student{name = wangwu, age = 25}, Student{name = lisi, age = 24}, Student{name = zhangsan, age = 18}]

        // 通过结果可看出，linkedHashSet可以保证数据的存储顺序。
    }
}

package day22_DataStructures.Collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * public boolean add(E e)          添加
 * public void clear()              清空
 * public boolean remove(E e)       删除
 * public boolean contains(E e)     判断是否包含
 * public boolean isEmpty()         判断是否为空
 * public int size()                集合长度
 *
 * 注意点：
 * Collection是一个接口，我们不能直接创建它的对象。
 * 所以，现在我们学习它的方法时，只能创建它实现类的对象。
 * 实现类： ArrayList
 */
public class A01 {
    public static void main(String[] args) {
        Collection<String> coll1 = new ArrayList<>();

        // 1.添加元素
        // 细节：
        // 如果我们要往List系列集合中添加数据，方法永远返回true，因为List系列是允许元素重复的。
        // 但是，如果往Set系列集合中添加数据，如果添加的数据已经存在，则返回false，表示添加失败，因为Set系列的集合不允许重复。

        // 添加
        coll1.add("aaa");
        coll1.add("aaa");
        coll1.add("aaa");
        coll1.add("ccc");
        coll1.add("aaa");
        coll1.add("ccc");
        coll1.add("ddd");
        System.out.println(coll1);// [aaa, aaa, aaa, ccc, aaa, ccc, ddd]
        // contains 判断是否包含
        // 细节：底层是依赖equals方法判断是否包含的。
        // 所以，如果集合中存储的是自定义对象，那么自定义类中必须重写equals方法。
        if (coll1.contains("aaa")){
            System.out.println("删除 aaa");
            // 删除
            // 细节1:因为Collection里面定义的是共性的方法，所以此时不能通过索引进行删除，只能通过元素的对象进行删除。
            // 细节2:方法会有一个布尔类型的返回值，删除成功会返回true,删除时候返回false
            coll1.remove("aaa");
            System.out.println(coll1);// [aaa, aaa, ccc, aaa, ccc, ddd]
            // 删除所有aaa
            coll1.removeIf("aaa"::equals);
            System.out.println(coll1);// [ccc, ccc, ddd]
        }
        // isEmpty 判断集合是否为空
        if ( !coll1.isEmpty() ) {
            System.out.println("要清空啦");
            // 清空
            coll1.clear();
        }
        System.out.println(coll1);// []

    }
}

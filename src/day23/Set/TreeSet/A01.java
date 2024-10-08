package day23.Set.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet特点
 * - 不重复、无索引、可排序
 * - 可排序：按照元素的默认规则（从小到大）排序。
 * - TreeSet集合底层是基于红黑树的数据结构实现排序的，增删改查的性能都较好。
 *
 * TreeSet集合自定义排序规则
 * - 方式一：Javabean类实现Comparable接口，重写compareTo方法，指定比较规则。
 * - 方式二：创建集合时，自定义Comparator比较器对象，指定比较规则
 * *注意*：方式一和方式二同时存在时，以方式二为准。
 *
 * 方法返回值特点：
 * - 负数：表示当前要添加的元素是小的，存左边。
 * - 正数：表示当前要添加的元素是大的，存右边。
 * - 0：表示当前要添加的元素已存在，舍弃不存。
 *
 */
public class A01 {
    public static void main(String[] args) {
        /**
         * 需求：利用TreeSet存储整数并进行排序
         */

        // 1.创建TreeSet集合对象
        TreeSet<Integer> ts = new TreeSet<>();

        // 2.添加元素
        ts.add(40);
        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(20);

        // 3.打印集合
        System.out.println(ts);// [10, 20, 30, 40, 50]

        // 4.遍历集合
        System.out.println("迭代器遍历");
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()){
            System.out.println(it.next()); // 10 20 30 40 50
        }

        System.out.println("增强For遍历");
        for (Integer i : ts){
            System.out.println(i);// 10 20 30 40 50
        }

        System.out.println("Lambda表达式遍历");
        ts.forEach( j->System.out.println(j) );// 10 20 30 40 50

    }
}

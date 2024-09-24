package day22_DataStructures.Collection;
/**
 * 迭代器遍历的四个方法：
 * 1. Iterator<E> iterator：获取一个迭代器对象</E>
 * 2. next()：获取当前指向的元素并移动指针
 * 3. hasNext()：判断当前指向的为止是否有元素。
 * 4. remove()：删除当前位置的元素。
 *
 *
 * 迭代器的细节注意点：
 * 1.报错NoSuchElementException
 * 2.迭代器遍历完毕，指针不会复位
 * 3.循环中只能用一次next方法
 * 4.迭代器遍历时，不能用集合的方法进行增加或者删除
 *
 * 为什么需要重新定义迭代器
 * 迭代器状态的变化：
 * 当你遍历集合时，迭代器会记住当前位置。
 * 如果你在遍历过程中删除了元素，迭代器的状态会发生变化，可能不再有效。
 * 迭代器的有效性：
 * 迭代器的有效性取决于集合的状态。
 * 如果集合被修改（如删除元素），原来的迭代器可能变得无效。
 *
 * 总结
 * 使用迭代器删除元素时，需要重新定义迭代器的原因主要是为了保证迭代器的状态和有效性。
 * 这样可以确保在删除元素后，再次遍历集合时能够正确地获取到最新的状态。这样做不仅更加安全，也更加符合迭代器的设计原则。
 */

import java.util.ArrayList;
import java.util.Iterator;

public class A03 {
    public static void main(String[] args) {
        // 创建一个ArrayList并添加一些元素
        ArrayList<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("apple");
        list.add("orange");

        // 使用迭代器遍历集合
        System.out.println("Original list:");
        // 获取迭代器对象
        // 迭代器对象就好比是一个箭头，默认指向集合的0索引处
        Iterator<String> it1 = list.iterator();
        while (it1.hasNext()){
            // next方法的两件事情：获取元素，并移动指针
            String item = it1.next();
            System.out.println(item);
        }

        /**
         * 当上面循环结束后，迭代器的指针已经指向了最后没有元素的位置
         */
//        System.out.println(iterator.next()); // java.util.NoSuchElementException

        // 迭代器遍历完毕，指针不会复位
        System.out.println(it1.hasNext()); // false

        // 使用迭代器删除所有"apple"
        System.out.println("\nRemoving all 'apple' elements:");
        //如果我们要继续第二次遍历集合，只能再次获取一个新的迭代器对象
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()){
            String item = it2.next();
            if ( "apple".equals( item ) ){
                // 当使用 Iterator 的 remove() 方法删除元素时，迭代器会自动处理内部的索引和修改计数
                // 保证不会抛出 ConcurrentModificationException 异常。
                it2.remove();
            }
        }

        // 再次遍历集合查看结果
        System.out.println("\nList after removing 'apple':");
        Iterator<String> it3 = list.iterator();
        while (it3.hasNext()) {
            String item = it3.next();
            System.out.println(item);
        }
    }
}

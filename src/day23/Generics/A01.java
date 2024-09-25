package day23.Generics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 泛型的好处
 * 1.统一数据类型。
 * 2.把运行时期的问题提前到了编译期间，避免了强制类型转换可能出现的异常，因为在编译阶段类型就能确定下来。
 *
 * 泛型的细节
 * 1.泛型中不能写基本数据类型。
 * 2.指定泛型的具体类型后，传递数据时，可以传入该类类型或者其子类类型。
 * 3.如果不写泛型，类型默认是Object。
 */
public class A01 {
    public static void main(String[] args) {
        // 没有泛型的时候，集合如何存储数据
        // 结论：
        // 如果我们没有给集合指定类型，默认认为所有的数据类型都是Object类型
        // 此时可以往集合添加任意的数据类型。
        // 带来一个坏处：我们在获取数据的时候，无法使用它的特有行为，除非强制转换类型。

        // 此时推出了泛型，可以在添加数据的时候就把类型进行统一。
        // 而且我们在获取数据的时候，也省得强转类，非常的方便。

        // 1.创建集合的对象
        ArrayList list = new ArrayList();

        // 2.添加数据
        list.add(123);
        list.add("好好学习，天天向上");
        list.add(new Student("zhangsan",25));

        // 3.遍历集合获取里面的每一个元素
        Iterator it = list.iterator();
        while (it.hasNext()){
            Object obj = it.next();
//            String str = (String)it.next(); // 此行会报错

            // 多态的弊端是不能访问子类特有方法
            if (obj instanceof Student st){
                System.out.println(st.getName() + " " + st.getAge());
            } else if(obj instanceof String s){
                System.out.println(s.substring(2, 4));
            } else if (obj instanceof Integer i) {
                System.out.println(i);
            }

        }
    }
}

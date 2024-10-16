package day26_Stream.Stream;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 单列集合获取Stream流
 * default Stream<E> stream()      Collection接口中的默认方法
 */
public class demo2 {
    public static void main(String[] args) {
        // 1.单列集合获取Stream流
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");

        /* // 获取到一条流水线，并把集合中的数据放到流水线上
        Stream<String> stream1 = list.stream();
        // 使用终结方法打印一下流水线上的所有数据
        stream1.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                // s:依次表示流水线上的每一个数据
                System.out.println(s);
            }
        });
         */
        list.stream().forEach(s-> System.out.println(s));
    }
}

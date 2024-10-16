package day26_Stream.Stream;

import java.util.ArrayList;
import java.util.Collections;

/**
 * filter 过滤
 */
public class demo6 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山","张亮","谢昆");

        System.out.println("--------- filter 过滤 ---------------");
        // 把"张"开头的留下，其余的数据过滤不要

        /*
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                // true  当前数据留下
                // false 当前数据舍弃不要
                return s.startsWith("张");
            }
        }).forEach(s-> System.out.println(s));
        */

        // 改成Lambda表达式
        list.stream()
                .filter(s -> s.startsWith("张"))
                .filter(s -> s.length() == 3)
                .forEach(s -> System.out.println(s));

        System.out.println("---------!! 修改Stream流中的数据，不会影响原来集合或数组中的数据 !! -------------");
        System.out.println(list);

        System.out.println("--------- limit 获取前几个数据 ---------------");
        list.stream()
                .limit(3).
                forEach(s -> System.out.println(s));

        System.out.println("--------- skip  跳过前几个数据 ---------------");
        list.stream()
                .skip(3)
                .forEach(s -> System.out.println(s));

        System.out.println("--------- 课堂练习 ---------------");
        // 只显示第4-6个数据 张强 张三丰 张翠山
        System.out.println("--------- 思路1 ---------------");
        // 跳过3个，再只显示3个
        list.stream()
                .skip(3)
                .limit(3)
                .forEach(s -> System.out.println(s));
        System.out.println("--------- 思路2 ---------------");
        // 显示前6个，再跳过3个
        list.stream()
                .limit(6)
                .skip(3)
                .forEach(s -> System.out.println(s));

    }
}

package day26_Stream.Function;

import java.util.ArrayList;
import java.util.Collections;

public class demo2 {
    public static void main(String[] args) {
        /*
        方法引用（引用静态方法）
        格式：
            类::方法名

         需求：
            集合中有以下数字，要求把他们都变成int类型
            "1","2","3","4","5"
         */

        // 1.创建集合并添加元素
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5");
        // 2.把它们都变成int类型
        /*
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.parseInt(s);
            }
        }).forEach(s-> System.out.println(s));
        */
        // 1.方法需要已经存在
        // 2.方法的形参和返回值类型与抽象方法中的形参和返回值类型一致
        // 3.方法的功能需要把形参的字符串转换成整数
        list.stream().map(Integer::parseInt).forEach(s->System.out.println(s));
    }
}

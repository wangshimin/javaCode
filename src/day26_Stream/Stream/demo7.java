package day26_Stream.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/**
 * distinct 去重
 * concat 合并两个流
 */
public class demo7 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "张无忌", "周芷若", "张无忌", "张翠山","张亮","谢昆");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "小可","张无忌","赵敏","周芷若");

        System.out.println("--------- distinct 元素去重，依赖（集合中的hashCode和equals方法） ---------------");
        list1.stream()
                .distinct()
                .forEach(s -> System.out.println(s));

        System.out.println("--------- concat 合并a和b两个流为一个流 ---------------");
        Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .forEach(s -> System.out.println(s));

    }
}

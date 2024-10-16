package day26_Stream.Stream;

import java.util.ArrayList;

public class demo1 {
    public static void main(String[] args) {
        /*
            创建集合添加元素，完成以下需求：
            1.把所有以"张"开头的元素存储到新集合中
            2.把"张"开头的，长度为3的元素再存储到新集合中
            3.遍历打印最终结果
         */
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("张无忌");
        list1.add("周芷若");
        list1.add("赵敏");
        list1.add("张强");
        list1.add("张三丰");

         /*
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();

        for (String name : list1) {
            if (name.startsWith("张")) {
                // 1.把所有以"张"开头的元素存储到新集合中
                list2.add(name);
                // 2.把所有以"张"开头的元素存储到新集合中
                if (name.length() == 3) {
                    list3.add(name);
                }
            }
        }
        System.out.println(list2);
        System.out.println(list3);
         */

        // stream()把集合转换为流
        list1.stream().filter(name->name.startsWith("张")).filter(name -> name.length() == 3).forEach(name->System.out.println(name));

    }
}

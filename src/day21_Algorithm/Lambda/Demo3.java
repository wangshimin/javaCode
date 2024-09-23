package day21_Algorithm.Lambda;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Lambda表达式的省略规则：
 * 1. 参数类型可省略不写。
 * 2.如果只有一个参数，参数类型可以省略，同时() 也可以省略。
 * 3. 如果Lambda表达式的函数体只有一行代码，可以省略大括号和return关键字和分号，需同时省略。
 */
public class Demo3 {
    public static void main(String[] args) {
        Integer[] arr = {2, 4, 1, 5, 9, 6, 3, 8, 7};

//        // 匿名内部类的写法
//        Arrays.sort(arr, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        });

//        // Lambda完整格式
//        Arrays.sort(arr, (Integer o1, Integer o2) -> {
//                return o1 - o2;
//            }
//        );
        // Lambda省略写法
        Arrays.sort(arr, (o1, o2) -> o2 - o1);
        System.out.println(Arrays.toString(arr));
    }
}

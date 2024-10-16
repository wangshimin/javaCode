package day26_Stream.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 数组获取Stream流
 * public static <T> Stream<T> stream(T[] array)  Arrays工具中的静态方法|
 */
public class demo4 {
    public static void main(String[] args) {
        // 1. 创建数组
        String[] arr = {"张无忌", "周芷若", "赵敏", "张强", "张三丰"};

        // 2. 获取Stream流
        Stream<String> stream = Arrays.stream(arr);

        // 3. 遍历打印
        stream.forEach(name -> System.out.println(name));
    }
}

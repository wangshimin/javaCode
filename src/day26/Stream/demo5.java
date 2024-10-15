package day26.Stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 一堆散列数据，获取Stream数据流
 * public static Stream<T> of(T... values)     Stream接口中的静态方法
 */
public class demo5 {
    public static void main(String[] args) {

        Stream.of(1, 2, 3, 4, 5).forEach(s-> System.out.print(s + " "));// 1 2 3 4 5
        System.out.println("----------------------");

        Stream.of("b","A","d","E").forEach(s-> System.out.print(s + " "));// b A d E
        System.out.println("----------------------");

        Stream.of(1,"bb",13.2).forEach(s-> System.out.print(s + " "));// 1 bb 13.2
        System.out.println("----------------------");
        /**
         * 注意：
         * Stream接口中静态方法of的细节
         * 方法的形参是一个可变参数，可以传递一堆零散的数据，也可以传递数组
         * 但是数组必须是引用数据类型的，如果传递的是基本数据类型，是会把整个数组当作一个元素，放到Stream当中
         */
        int[] arr1 = {2,9,35,7,39,67};
        Stream.of(new int[]{3,6,4}).forEach(System.out::println);// [I@1d81eb93
        Stream.of(arr1).forEach(System.out::println);           // [I@723279cf
        Arrays.stream(arr1).forEach(s-> System.out.print(s + " ")); // 2 9 35 7 39 67
        System.out.println("----------------------");

        Stream.of(new Integer[]{3,6,4}).forEach(s-> System.out.print(s + " "));// 3 6 4
        System.out.println("----------------------");
        Stream.of(new String[]{"aa","bc","cc"}).forEach(s-> System.out.print(s + " "));// aa bb cc
    }
}

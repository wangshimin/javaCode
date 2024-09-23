package day21_Algorithm.Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo1 {
    public static void main(String[] args) {
        Integer[] arr = {2, 3, 1, 5, 7, 6, 8, 4, 9};
/*        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });*/
        // 初识Lambda表达式
        Arrays.sort(arr, (Integer o1, Integer o2)->{
                    return o1 - o2;
                }
        );

        System.out.println(Arrays.toString(arr));
    }
}

package day26.StreamTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

/**
 * 数据过滤
 *
 * 定义一个集合，并添加一些整数 1，2，3，4，5，6，7，8，9，10
 * 过滤奇数，只留下偶数，并将结果保存起来
 */
public class demo1 {
    public static void main(String[] args) {
        // 1. 定义一个集合
        ArrayList<Integer> list = new ArrayList<>();
        // 2.添加一些整数
        Collections.addAll(list, 1,2,3,4,5,6,7,8,9,10);
        // 3.过滤奇数，只留下偶数
        // 进行判断，如果是偶数，返回true 保留
        List<Integer> newList = list.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());
        // 4.打印集合
        System.out.println(newList);// [2, 4, 6, 8, 10]
    }
}

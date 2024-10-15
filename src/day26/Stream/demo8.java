package day26.Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

/**
 * map 转换流中的数据类型
 */
public class demo8 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-15", "周芷若-13", "赵敏-12", "张强-46", "张三丰-32", "张翠山-63","张亮-8","谢昆-70");
        System.out.println("--------- map 转换流中的数据类型 ---------------");
        // 需求：只获取里面的年龄并进行打印
        // String -> int
        list.stream()
                // 第一个类型：流中原本的数据类型
                // 第二个类型：转换后的数据类型
                // map方法执行完毕之后，流上的数据就变成了整数
                // 所以在下面的forEach方法中，s依次表示流里面的每一个数据，这个数据现在就是整数了
                .map(new Function<String, Integer>() {
                    /**
                     * 对流中的每一个数据进行转换
                     * @param s the function argument  依次表示流里面的每一个数据
                     * @return 转换之后的数据
                     */
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[1]);
                    }
                })
                .forEach(s -> System.out.print(s + " ")); // 15 13 12 46 32 63 8 70
        System.out.println();
        System.out.println("----------- 改成 Lambda 表达式 --------");

        list.stream()
                .map(s -> Integer.parseInt(s.split("-")[1]))
                .forEach(s -> System.out.print(s + " "));// 15 13 12 46 32 63 8 70
    }
}

package day26_Stream.Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;
import java.util.function.IntFunction;

public class demo9 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰", "张翠山","张亮","谢昆");

        System.out.println("--------- forEach 遍历 ---------------");

        /**
         * Consumer的范型：表示流中数据的类型
         * accept方法的形参s：依次表示流中每一个数据
         * 方法体：对每一个数据的处理操作（打印）
         */
        list.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("------- 改成 Lambda表达式");
        list.stream().forEach(s -> System.out.println(s));

        System.out.println("--------- count 统计 ---------------");
        long count = list.stream().count();
        System.out.println(count);

        System.out.println("--------- toArray 收集流中的数据，放到数组中 ---------------");
        Object[] arr1 = list.stream().toArray();
        System.out.println(Arrays.toString(arr1));// [张无忌, 周芷若, 赵敏, 张强, 张三丰, 张翠山, 张亮, 谢昆]

        // IntFunction的范型：具体类型的数组
        // apply方法的形参：表示流中数据的个数，要跟数组的长度保持一致
        // 方法体：创建数组，返回数组

        // toArray方法的参数的作用：负责创建一个指定类型的数组
        // toArray方法的底层：会依次得到流里面的每一个数据，并把数据放到数组中
        // toArray方法的返回值：是一个装着流里面所有数据的数组
        String[] arr2 = list.stream().toArray(new IntFunction<String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(arr2)); // [张无忌, 周芷若, 赵敏, 张强, 张三丰, 张翠山, 张亮, 谢昆]

        System.out.println("----------- 改成 Lambda 表达式 --------");
        String[] arr3 = list.stream().toArray(value -> new String[value]);
        System.out.println(Arrays.toString(arr3));// [张无忌, 周芷若, 赵敏, 张强, 张三丰, 张翠山, 张亮, 谢昆]

    }
}

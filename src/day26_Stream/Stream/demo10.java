package day26_Stream.Stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * collect 收集流中的数据，放到集合中（List Set Map）
 *
 * 注意点：
 *      放到Map集合中时，键不能重复，否则会报错
 */
public class demo10 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌-男-15","周芷若-女-13", "赵敏-女-12", "张强-男-46", "张三丰-男-32", "张翠山-男-63","张亮-男-8","谢昆-男-70");
        System.out.println("--------- collect 收集流中的数据，放到集合中（List Set Map） ---------------");

        // 需求：把所有的男性收集起来
        System.out.println("--------- 收集到List集合当中 --------- ");
        List<String> newList = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(newList);// [张无忌-男-15, 张强-男-46, 张三丰-男-32, 张翠山-男-63, 张亮-男-8, 谢昆-男-70]

        System.out.println("--------- 收集到Set集合当中 --------- ");
        Set<String> newSet = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toSet());
        System.out.println(newSet); // [谢昆-男-70, 张亮-男-8, 张三丰-男-32, 张无忌-男-15, 张强-男-46, 张翠山-男-63]

        System.out.println("--------- 收集到Map集合当中 --------- ");
        // 键：姓名 值：年龄
        Map<String, Integer> map1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                /**
                 * toMap ： 参数一表示键的生成规则，参数二表示值的生成规则
                 *
                 * 参数一：
                 *      Function 范型一：表示流中每一个数据的类型
                 *               范型二：表示Map集合中键的数据类型
                 *
                 *      方法apply  形参：依次表示流里面的每一个数据
                 *               方法体：生成键的代码
                 *               返回值：已经生成的键
                 *
                 *               ！！默认情况下，如果键重复，那么会报错 ！！
                 * 参数二：
                 *      Function 范型一：表示流中每一个数据的类型
                 *               范型二：表示Map集合中值的数据类型
                 *
                 *      方法apply  形参：依次表示流里面的每一个数据
                 *               方法体：生成值的代码
                 *               返回值：已经生成的值
                 *
                 */
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(map1);// {张强=46, 张翠山=63, 张亮=8, 谢昆=70, 张三丰=32, 张无忌=15}

        System.out.println("----------- 匿名内部类 改成 Lambda 表达式 --------");
        Map<String, String> map2 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(s -> s.split("-")[0], s -> s.split("-")[2]));

        System.out.println(map2); // {张强=46, 张翠山=63, 张亮=8, 谢昆=70, 张三丰=32, 张无忌=15}
    }
}

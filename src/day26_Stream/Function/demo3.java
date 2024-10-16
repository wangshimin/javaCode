package day26_Stream.Function;

import java.util.ArrayList;
import java.util.Collections;

public class demo3 {
    public static void main(String[] args) {
        /*
        方法引用（引用成员方法）
        格式
                其他类：其他类对象::方法名
                本类：this::方法名(引用处不能是静态方法)
                父类：super::方法名(引用处不能是静态方法)
        需求：
            集合中有一些名字，按照要求过滤数据
            数据："张无忌","周芷若","赵敏","张强","张三丰"
            要求：只要以张开头，而且名字是3个字的

       */

        //1.创建集合
        ArrayList<String> list = new ArrayList<>();
        // 2.添加数据
        Collections.addAll(list, "张无忌", "周芷若", "赵敏", "张强", "张三丰");
        // 3.过滤数据(只要以张开头，而且名字是3个字的)
//        list.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(s -> System.out.println(s));
        /*
        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张") && s.length() == 3;
            }
        }).forEach(s -> System.out.println(s));
        */

        System.out.println("--------- 其他类：其他类对象::方法名 ------");
        StringOperation so = new StringOperation();
        list.stream().filter(so::stringJuge).forEach(s -> System.out.println(s));

        // 当前引用处是静态方法main，静态方法中是没有this的
        // 所以只能使用本类对象来调用方法
        list.stream().filter(new demo3()::stringJuge1).forEach(s -> System.out.println(s));
    }

    public boolean stringJuge1(String s){
        return s.startsWith("张") && s.length() == 3;
    }
}

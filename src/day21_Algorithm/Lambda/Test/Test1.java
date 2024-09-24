package day21_Algorithm.Lambda.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        /**
         * 定义数组并存储一些女朋友对象，利用Arrays中的sort方法进行排序。
         * 要求：
         * 1.属性中有姓名、年龄、身高。
         * 2.按照年龄中的大小进行排序，年龄一样，按照身高排序，身高一样按照姓名进行排序。
         * （姓名中不要有中文或特殊字符，会涉及到后面的知识）
         */
        String s1 = "abc";
        String s2 = "abew";
        System.out.println(s1.compareTo(s2)); // -2
        System.out.println(s2.compareTo(s1)); // 2
        System.out.println('a'-'c');// -2

        // 1.创建三个女朋友的对象
        GirlFriend gf1 = new GirlFriend("shishi", 18, 1.68);
        GirlFriend gf2 = new GirlFriend("huihui", 19, 1.78);
        GirlFriend gf3 = new GirlFriend("andy", 19, 1.78);
        GirlFriend gf4 = new GirlFriend("dandan", 19, 1.72);

        // 2.定义数组存储女朋友的信息
        GirlFriend[] arr = {gf1, gf2, gf3, gf4};

        // 3.利用Arrays中的sort方法进行排序
/*
        // 匿名内部类
        Arrays.sort(arr, new Comparator<GirlFriend>() {
            @Override
            public int compare(GirlFriend o1, GirlFriend o2) {
                // 获取属性值
                int age1 = o1.getAge();
                int age2 = o2.getAge();
                double height1 = o1.getHeight();
                double height2 = o2.getHeight();
                String name1 = o1.getName();
                String name2 = o2.getName();

                // 按照年龄进行排序
                if (age1 != age2) {
                    return Integer.compare(age1, age2);
                }

                // 年龄相同，按照身高排序
                if (height1 != height2) {
                    return Double.compare(height1, height2);
                }

                // 身高相同，按照姓名排序
                return name1.compareTo(name2);
            }
        });
*/
        // Lambda表达式
        // () -> {}
        // () : 对应着抽象方法的形参
        // {} : 方法体
        Arrays.sort(arr, (o1, o2) -> {
                // 获取属性值
                int age1 = o1.getAge();
                int age2 = o2.getAge();
                double height1 = o1.getHeight();
                double height2 = o2.getHeight();
                String name1 = o1.getName();
                String name2 = o2.getName();

                // 按照年龄进行排序
                if (age1 != age2) {
                    return Integer.compare(age1, age2);
                }

                // 年龄相同，按照身高排序
                if (height1 != height2) {
                    return Double.compare(height1, height2);
                }

                // 身高相同，按照姓名排序
                return name1.compareTo(name2);
            }
        );
        for (GirlFriend gf : arr) {
            System.out.println(gf.getAge() + " " + gf.getHeight() + " " + gf.getName());
        }

    }
}



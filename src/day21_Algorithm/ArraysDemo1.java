package day21_Algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDemo1 {
    public static void main(String[] args) {

//        d1();
        d2();
    }

    /**
     * public static void sort(数组, 数组规则) 按照指定的规则排序
     *
     * 参数一：要排序的数组
     * 参数二：排序的规则
     * 细节：
     *      只能给引用数据类型的数组进行排序
     *      如果数组是基本数据类型的，需要变成其对应的包装类
     */
    private static void d2() {
        Integer[] arr = {20, 50, 70, 40, 90, 30, 60};

        // 第二个参数是一个接口，所以我们在调用方法的时候，需要传递这个接口的实现类对象，作为排序的规则。
        // 但是这个实现类，我只要使用一次，所以就没有必要单独的去写一个类，直接采取匿名内部类的方法就可以了。

        // 底层原理：
        // 利用插入排序 + 二分查找的方式进行排序的。
        // 默认把0索引的数据当作是有序的序列，1索引到最后认为是无序的序列。
        // 遍历无序的序列得到里面的每一个元素，假设当前遍历得到的元素是A元素。
        // 把A往有序序列中进行插入，在插入的时候，是利用二分查找确定A元素的插入点。
        // 拿着A元素，跟插入点的元素进行比较，比较的规则就是compare方法的方法体
        // 如果方法的返回值是负数，拿着A继续跟前面的数据进行比较
        // 如果方法的返回值是正数，拿着A继续跟后面的数据进行比较
        // 如果方法的返回值是0，也拿着A跟后面的数据进行比较。
        // 直到能确定A的最终位置为止。

        // Compare方法的形式参数：
        // o1：表示在无序序列中，遍历得到的每一个元素
        // o2：有序序列中的元素

        // 返回值
        // 负数：表示当前要插入的元素是小的，需放在前面
        // 整数：表示当前要插入的元素是大的，需放在后面
        //   0： 表示当前要插入的元素跟现在的元素是一样的，也会放在后面

        // 简单理解：
        // o1 - o2 : 升序排列
        // o2 - o1 : 降序排列
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("----------------");
                System.out.println("o1："+ o1 +"   o2：" + o2);
                return o1 - o2;
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private static void d1() {
        int[] arr = {1, 4, 6, 8, 10, 19, 33, 40, 55};

        System.out.println("--------------- toString 将数组变成字符串 ------------");
        System.out.println(Arrays.toString(arr));

        System.out.println("--------------- binarySearch 二分查找法查找元素 ------------");
        // 注意：
        // 1.二分查找的前提数组元素必须有序，且为升序。
        // 2.查找的元素不存在的话，返回的是 -插入点 -1
        // 疑问：为何要减1呢？
        // 解释：如果此时，要查找数字0，此时0是不存在的，若按照上面的规则-插入点，应该就是-0
        // 为了避免这样的情况，java在这个基础上又减一。
        System.out.println(Arrays.binarySearch(arr, 8)); // 3
        System.out.println(Arrays.binarySearch(arr, 30)); // -7
        System.out.println(Arrays.binarySearch(arr, 7)); // -4

        System.out.println("--------------- copyOf 拷贝数组------------");
        int[] newArr1 = Arrays.copyOf(arr, 5);
        System.out.println(Arrays.toString(newArr1));

        System.out.println("--------------- copyofRange 拷贝数组（指定范围）------------");
        // 细节：包头到包尾，包尾不包含
        int[] newArr2 = Arrays.copyOfRange(arr, 2, 5);
        System.out.println(Arrays.toString(newArr2));

        System.out.println("--------------- fill 填充数组------------");
        Arrays.fill(arr, 100);
        System.out.println(Arrays.toString(arr));

        System.out.println("--------------- sort 排序------------");
        // 默认为升序，底层用的是快速排序
        int[] arr2 = {10, 2, 3, 7, 9, 15, 4, 1};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }
}

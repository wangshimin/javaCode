package day24_Map.Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历方式：通过键找值
 */
public class A02 {
    public static void main(String[] args) {
        // 1.创建Map集合对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        map.put("郭靖", "黄蓉");
        map.put("杨过", "小龙女");
        map.put("张无忌", "赵敏");

        // 3.通过键找值

        // 3.1 获取所有的键，把这些键放到一个单列集合中
        Set<String> keys = map.keySet();
        // 3.2 遍历这个单列集合，得到每一个键，通过键得到对应的值
        System.out.println("Lambda表达式遍历");
        keys.forEach(key -> System.out.println(key + " =   " + map.get(key)));
        System.out.println("==========================");

        System.out.println("迭代器遍历");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key + " = " + map.get(key));
        }
        System.out.println("==========================");

        System.out.println("增强For遍历");
        for (String key : keys) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}

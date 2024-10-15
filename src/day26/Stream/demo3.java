package day26.Stream;

import java.util.HashMap;

/**
 * 双列集合，无法直接使用Stream流式处理
 */
public class demo3 {
    public static void main(String[] args) {
        // 1.创建双列集合
        HashMap<String, Integer> hm = new HashMap<>();
        // 2.添加数据
        hm.put("张三", 23);
        hm.put("李四", 24);
        hm.put("王五", 25);
        hm.put("赵六", 26);
        hm.put("孙七", 27);
        // 3.第一种获取Stream流
        hm.keySet().stream().forEach(s-> System.out.println(s));
        hm.values().stream().forEach(s-> System.out.println(s));
        // 4.第二种获取Stream流
        hm.entrySet().stream().forEach(s->{
            System.out.println(s.getKey() + " : " + s.getValue());
        });
    }
}

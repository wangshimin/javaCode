package day24_Map.Map;

import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 *  Map集合的遍历方式：Lambda表达式
 */
public class A04 {
    public static void main(String[] args) {
        // 1.创建Map集合对象
        HashMap<String, String> map = new HashMap<>();

        // 2.添加元素
        // 健： 人物名字
        // 值： 名人名言
        map.put("鲁迅", "这句话是我说的");
        map.put("曹操", "不可能绝对不可能");
        map.put("刘备", "接着奏乐接着舞");
        map.put("柯镇恶","看我眼色行事");

        // 3. 利用Lambda表达式进行遍历
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " = " + s2);
            }
        });
        System.out.println("=======================");
        map.forEach((key,  value)->System.out.println(key + " " + value));
    }
}

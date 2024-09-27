package day24_Map.Map;

import java.util.HashMap;
import java.util.Map;

public class A01 {
    public static void main(String[] args) {
        /*
            V put(K key,V value)                    添加元素
            V remove(Object key)                    根据键删除键值对元素
            void clear()                            移除所有的键值对元素
            boolean containsKey(Object key)         判断集合是否包含指定的键
            boolean containsValue(Object value)     判断集合是否包含指定的值
            boolean isEmpty()                       判断集合是否为空
            int size()                              集合的长度，也就是集合中键值对的个数
        */


        //1.创建Map集合的对象
        Map<String, String> m = new HashMap<>();

        // 2.添加元素
        // put方法的细节：
        // 添加/覆盖
        // 在添加数据的时候，如果键不存在，那么直接把键值对对象添加到map集合当中,方法返回null
        // 在添加数据的时候，如果键是存在的，那么会把原有的键值对对象覆盖，会把被覆盖的值进行返回。
        System.out.println(m.put("郭靖", "黄蓉"));
        m.put("韦小宝","沐剑屏");
        m.put("张无忌","赵敏");

//        String v = m.put("韦小宝", "双儿");
//        System.out.println(v);

        // 删除
        String result = m.remove("郭靖");
        System.out.println(result);

        // 清空
//        m.clear();

        // 判断是否包含
        System.out.println(m.containsKey("韦小宝"));// true
        System.out.println(m.containsKey("沐剑屏")); // false
        System.out.println(m.containsValue("赵敏")); // true

        if ( m.isEmpty() ){
            System.out.println("集合为空");
        }else{
            System.out.println("集合不为空，长度为"+ m.size());
        }


        // 3.打印集合
        System.out.println(m);
    }
}

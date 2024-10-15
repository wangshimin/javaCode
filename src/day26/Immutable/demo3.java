package day26.Immutable;

import java.util.Map;
import java.util.Set;

public class demo3 {
    public static void main(String[] args) {
        /**
         * 创建不可变的Map集合
         *
         * 细节：
         * 1.键是不能重复的
         * 2.Map里面的of方法， 参数是有上限的，最多只能传递20个参数，也就是10个键值对
         * 3.如果我们要传递多个键值对对象，数量大于10个，那么就只能使用Map的ofEntries方法
         */
        Map<String, String> map = Map.of("张三", "南京", "李四", "北京", "王五", "上海",
                "赵六", "广州", "孙七", "深圳");

        Set<String> keys = map.keySet();
        for (String key : keys) {
            String value = map.get(key);
            System.out.println( key + " : " + value);
        }

        System.out.println("----------------");

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }

        System.out.println("----------------");
    }
}

package day26_Stream.Immutable;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class demo4 {
    public static void main(String[] args) {
        /*
         创建不可变的Map集合，键值对的数量超过10个
         */
        d1();
//        d2();
    }

    private static void d1() {
        // 1.创建一个普通的Map集合
        HashMap<String, String> hm = new HashMap<>();
        hm.put("张三","南京");
        hm.put("李四","上海");
        hm.put("王五","北京");
        hm.put("赵六","广州");
        hm.put("孙七","深圳");
        hm.put("周八","武汉");
        hm.put("吴九","西安");
        hm.put("郑十","成都");
        hm.put("钱十一","重庆");
        hm.put("林十二","天津");
        hm.put("周十三","郑州");
        hm.put("刘十四","沈阳");
        hm.put("周十五","济南");
        hm.put("周十六","青岛");

        // 2.利用上面的数据来获取一个不可变的集合

        /*
        // 获取到所有的键值对对象（Entry对象）
        Set<Map.Entry<String, String>> entries = hm.entrySet();
        // 把Entry对象变成数组
        Map.Entry[] arr = new Map.Entry[0];
        // toArray() 方法在底层会比较集合的长度跟数组的长度两者的大小
        // 集合长度 > 数组长度：则创建一个和集合长度一样的数组，把集合中的元素拷贝到数组中
        // 集合长度 <= 数组长度：则把集合中的元素拷贝到数组中，如果数组的长度比集合的长度大，则把数组中的元素填充满，剩余的位置留空
        Map.Entry[] newArr = entries.toArray(arr);

        // 把数组中的每个元素变成不可变的Map集合
        Map map = Map.ofEntries(newArr);
        map.put("bbb","222");
         */

//        Map<Object, Object> map = Map.ofEntries(hm.entrySet().toArray(new Map.Entry[0]));
//        map.put("bbb","222");

        Map<String, String> map = Map.copyOf(hm); // 不可变集合
        map.put("bbb", "111"); // 报错
    }

    private static void d2() {
        // 1.创建一个不可变的Map集合
        Map<String,Integer> map = Map.ofEntries(
                Map.entry("a",1),
                Map.entry("b",2),
                Map.entry("c",3),
                Map.entry("d",4),
                Map.entry("e",5),
                Map.entry("f",6),
                Map.entry("g",7),
                Map.entry("h",8),
                Map.entry("i",9),
                Map.entry("j",10)
        );

//        System.out.println(map);
        // 2.打印键值对
        map.forEach((k,v)-> System.out.println(k + " : " + v));
        System.out.println("--------------------- ");

        Set<Map.Entry<String, Integer>> entries = map.entrySet(); // 获取到所有的键值对对象（Entry对象）
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

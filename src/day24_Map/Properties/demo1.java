package day24_Map.Properties;

import java.util.Properties;
import java.util.Set;

public class demo1 {
    public static void main(String[] args) {
        /*
            Properties 作为Map集合的操作
        */

        // 1.创建集合的对象
        Properties prop = new Properties();

        // 2.添加数据
        // 细节：虽然我们可以往Properties当中添加任意的数据类型，但是一般只会往里面添加字符串
        prop.put("张三", "100");
        prop.put("李四", "200");
        prop.put("王五", "300");
        prop.put("赵六", "400");
        prop.put("周七", "500");

        System.out.println("-------- Lambda 遍历");
        prop.forEach((k, v)->{
            System.out.println(k + "=" + v);
        });

        System.out.println("-------- 根据Keys 遍历");
        Set<Object> keys = prop.keySet();
        for (Object key : keys) {
            System.out.println(key + "=" + prop.get(key));
        }

        System.out.println("-------- 键值对对象 遍历");
        prop.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        });
        // 3.打印集合
        System.out.println(prop);
    }
}

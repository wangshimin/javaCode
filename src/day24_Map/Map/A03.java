package day24_Map.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Map集合的遍历方式：键值对
 */
public class A03
{
    public static void main(String[] args)
    {
        // 1.创建Map集合对象
        Map<String, String> map = new HashMap<>();

        // 2.添加元素
        // 键：人物的外号
        // 值： 人物的名字
        map.put("标枪选手", "马超");
        map.put("人物挂件", "明世隐");
        map.put("御龙骑士", "伊志平");

        // 3. 通过键值对对象进行遍历
        // 3.1 通过一个对象获取所有的键值对对象，返回一个Set集合
        Set<Map.Entry<String, String>> entries = map.entrySet();
        // 3.2 遍历Entry对象，得到每一个键值对对象，通过键值对对象得到键和值
        for (Map.Entry<String, String> entry : entries) {
            // 3.3 利用entry调用get方法获取键和值
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}

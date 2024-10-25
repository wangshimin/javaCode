package day24_Map.Properties;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class demo2 {
    public static void main(String[] args) throws IOException {
        /*
            Properties跟IO流结合的操作
        */

        // 1.创建集合
        Properties prop = new Properties();

        // 2.添加数据
        prop.put("张三", "100");
        prop.put("李四", "200");
        prop.put("王五", "300");
        prop.put("赵六", "400");
        prop.put("周七", "500");

        // 3.把集合中的数据以键值对的形式写到本地文件中

        // 之前的做法：
        BufferedWriter bw = new BufferedWriter(new FileWriter("myfile/a.properties"));
        Set<Map.Entry<Object, Object>> entries = prop.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            bw.write(key + "=" + value);
            bw.newLine();
        }
        bw.close();

        // 现在使用Properties的save方法
        FileOutputStream fos = new FileOutputStream("myfile/b.properties");
        prop.store(fos, "this is a test");
        fos.close();
    }
}

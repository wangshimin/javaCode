package day24_Map.Properties;

import java.io.*;
import java.util.Properties;

public class demo3 {
    public static void main(String[] args) throws IOException {
        // 1.创建集合
        Properties prop = new Properties();
        // 2.读取本地Properties文件里面的数据
//        BufferedReader br = new BufferedReader(new FileReader("myfile/b.properties"));
//        prop.load(br);
//        br.close();

        FileInputStream fis = new FileInputStream("myfile/b.properties");
        prop.load(fis);
        fis.close();

        // 3.打印集合
        System.out.println(prop);

    }
}

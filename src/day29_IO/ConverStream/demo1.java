package day29_IO.ConverStream;

import java.io.*;
import java.nio.charset.Charset;

public class demo1 {
    public static void main(String[] args) throws IOException {
        /*
           利用转换流按照指定字符编码读取（了解）

           因为JDK1中，这种方式被淘汰了，替代方案（需要掌握）
         */
/*
        // 1.创建一个转换流对象，指定字符编码为GBK
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myfile/gbkfile.txt"), "GBK");
        // 2.读取数据
        int ch;
        while ((ch = isr.read()) != -1){
            System.out.print((char) ch);
        }
        // 3.释放资源
        isr.close();

 */

        FileReader fr = new FileReader("myfile/gbkfile.txt", Charset.forName("GBK"));
        // 2.读取数据
        int ch;
        while((ch = fr.read()) != -1) {
            System.out.print((char) ch);
        }
        // 3.释放资源
        fr.close();
    }
}

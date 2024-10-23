package day29_IO.ConverStream;

import java.io.*;
import java.nio.charset.Charset;

public class demo2 {
    public static void main(String[] args) throws IOException {
         /*
            利用转换流按照指定字符编码写出
        */
/*
        // 1.创建一个转换流对象，指定字符编码为GBK
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile/tb.txt"), "GBK");
        // 2.写出数据
        osw.write("你好");
        // 3.释放资源
        osw.close();

 */
        FileWriter fw = new FileWriter("myfile/tc.txt", Charset.forName("GBK"));
        fw.write("你好呀小可爱");
        fw.close();
    }
}

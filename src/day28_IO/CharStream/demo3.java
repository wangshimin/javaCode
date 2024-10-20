package day28_IO.CharStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class demo3 {
    public static void main(String[] args) throws IOException {
        /*
            第一步：创建对象
                public FileWriter(File file)                            创建字符输出流关联本地文件
                public FileWriter(String pathname)                      创建字符输出流关联本地文件
                public FileWriter(File file,  boolean append)           创建字符输出流关联本地文件，续写
                public FileWriter(String pathname,  boolean append)     创建字符输出流关联本地文件，续写

            第二步：读取数据
                void write(int c)                           写出一个字符
                void write(String str)                      写出一个字符串
                void write(String str, int off, int len)    写出一个字符串的一部分
                void write(char[] cbuf)                     写出一个字符数组
                void write(char[] cbuf, int off, int len)   写出字符数组的一部分

            第三步：释放资源
                public void close()                 释放资源/关流


                '我'    25105
        */

        FileOutputStream fos = new FileOutputStream("myfile/a.txt");

        fos.write(97); // 字节流，每次只能操作一个字节，没办法满足一次性写入多个字符。

        fos.close();

        FileWriter fw = new FileWriter("myfile/b.txt", true);

//        fw.write("加油呀，小伙子");
//        fw.write(25105); // 根据字符集的编码方式进行编码，把编码之后的数据写到文件中去
        char[] chs = {'a', 'b', 'c','我'};
        fw.write(chs);

        fw.close();

    }
}

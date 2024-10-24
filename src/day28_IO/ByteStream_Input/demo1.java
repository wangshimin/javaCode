package day28_IO.ByteStream_Input;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo1 {
    public static void main(String[] args) throws IOException {
        /*
         * 演示：字节输入流FileInputStream
         * 实现需求：读取文件中的数据。（暂时不写中文）
         *
         * 实现步骤：
         *       创建对象
         *       读取数据
         *       释放资源
         * */


        //1.创建对象
        FileInputStream fis = new FileInputStream("myfile/a.txt");
        //2.读取数据
        int b1 = fis.read();
        System.out.println((char)b1);
        int b2 = fis.read();
        System.out.println((char)b2);
        int b3 = fis.read();
        System.out.println((char)b3);
        int b4 = fis.read();
        System.out.println((char)b4);
        int b5 = fis.read();
        System.out.println((char)b5);
        int b6 = fis.read();
        System.out.println(b6);
        //3.释放资源
        fis.close();
    }
}

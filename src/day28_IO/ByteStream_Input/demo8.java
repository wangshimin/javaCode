package day28_IO.ByteStream_Input;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo8 {
    public static void main(String[] args) {
        /*
         *
         *    JDK7:IO流中捕获异常的写法
         *
         *      try后面的小括号中写创建对象的代码，
         *          注意：只有实现了AutoCloseable接口的类，才能在小括号中创建对象。
         *     try(){
         *
         *     }catch(){
         *
         *     }
         *
         * */


        try (FileInputStream fis = new FileInputStream("myfile/b.txt");
             FileOutputStream fos = new FileOutputStream("myfile/copyb.txt")) {
            //2.拷贝
            int len;
            byte[] bytes = new byte[1024 * 1024 * 5];
            while ((len = fis.read(bytes)) != -1) {
                fos.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

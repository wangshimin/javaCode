package day28_IO.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class test2 {
    /*
            为了保证文件的安全性，就需要对原始文件进行加密存储，再使用的时候再对其进行解密处理。
            加密原理：
                对原始文件中的每一个字节数据进行更改，然后将更改以后的数据存储到新的文件中。
            解密原理：
                读取加密之后的文件，按照加密的规则反向操作，变成原始文件。


             ^ : 异或
                 两边相同：false
                 两边不同：true

                 0：false
                 1：true

               100:1100100
               10: 1010

               1100100
             ^ 0001010
             __________
               1101110
             ^ 0001010
             __________
               1100100

        */
    public static void main(String[] args) throws IOException {
//        System.out.println(100 ^ 10);// 结果是1101110转成十进制后就是110
//        System.out.println(110 ^ 10);// 结果1101110转成十进制后就是100
        // 结论：对一个数字进行两次异或，就会得到原始数字。那么就跟加密解密是一样的啦

        jiaMi();
        jieMi();

    }

    private static void jieMi() throws IOException {
        // 1.创建对象关联加密文件
        FileInputStream fis = new FileInputStream("/Users/wangshimin/test/AA/ency2.jpg");
        // 2.创建对象关联解密文件
        FileOutputStream fos = new FileOutputStream("/Users/wangshimin/test/AA/redu.jpg");
        // 3.解密处理
        int b;
        while ((b = fis.read()) != -1){
            fos.write( b ^ 2 );
        }
        // 4.释放资源
        fos.close();
        fis.close();
    }

    private static void jiaMi() throws IOException {
        // 1.创建对象关联原始文件
        FileInputStream fis = new FileInputStream("/Users/wangshimin/test/AA/2.jpg");
        // 2.创建对象关联加密文件
        FileOutputStream fos = new FileOutputStream("/Users/wangshimin/test/AA/ency2.jpg");
        // 3.加密处理
        int b;
        while ((b = fis.read()) != -1){
            fos.write( b ^ 2 );
        }
        // 4.释放资源
        fos.close();
        fis.close();
    }
}

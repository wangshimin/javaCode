package day27_Exception.File;

import java.io.File;

public class demo2 {
    public static void main(String[] args) {
        /*
        public boolean isDirectory()        判断此路径名表示的File是否为文件夹
        public boolean isFile()             判断此路径名表示的File是否为文件
        public boolean exists()             判断此路径名表示的File是否存在

        */

        //1.对一个文件的路径进行判断

        String str = "/Users/test/AA/a1/f1.txt";
        File f1 = new File(str);
        System.out.println( str + "是否为文件夹？"+ f1.isDirectory());  // false
        System.out.println( str + "是否为文件？" + f1.isFile());       // true
        System.out.println( str + "是否存在？" + f1.exists());        // true
        System.out.println("------------------------------------------------");

        //2.对一个文件夹的路径进行判断
        String str2 = "/Users/test/BB/";
        File f2 = new File(str2);
        System.out.println( str2 + "是否为文件夹？" + f2.isDirectory()); // true
        System.out.println( str2 + "是否为文件？" + f2.isFile());       // false
        System.out.println( str2 + "是否存在？" + f2.exists());        // true
        System.out.println("------------------------------------------------");

        //3.对一个不存在的路径进行判断
        String str3 = "/Users/test/BB/lllala/sss.txt";
        File f3 = new File(str3);
        System.out.println( str3 + "是否为文件夹？" + f3.isDirectory()); // false
        System.out.println( str3 + "是否为文件？" + f3.isFile());       // false
        System.out.println( str3 + "是否存在？" + f3.exists());        // false
        System.out.println("------------------------------------------------");

    }
}

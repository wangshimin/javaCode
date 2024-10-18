package day27_Exception.File;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo3 {
    public static void main(String[] args) {
        /*
        public long length()                返回文件的大小（字节数量）
        public String getAbsolutePath()     返回文件的绝对路径
        public String getPath()             返回定义文件时使用的路径
        public String getName()             返回文件的名称，带后缀
        public long lastModified()          返回文件的最后修改时间（时间毫秒值）
     */



        //1.length  返回文件的大小（字节数量）
        //细节1：这个方法只能获取文件的大小，单位是字节
        //如果单位我们要是M，G，可以不断的除以1024
        //细节2：这个方法无法获取文件夹的大小
        //如果我们要获取一个文件夹的大小，需要把这个文件夹里面所有的文件大小都累加在一起。
        File f1 = new File("/Users/test/AA/a1/f1.txt");
        long len = f1.length();
        System.out.println(len);

        System.out.println(new File("/Users/test").length());

        System.out.println("=============== getAbsolutePath 返回文件的绝对路径 ====================");
        //2.getAbsolutePath 返回文件的绝对路径
        System.out.println(f1.getAbsoluteFile());
        File f4 = new File("myFile/a.txt"); // 当前项目下的myFile/a.txt
        System.out.println(f4.getAbsoluteFile());

        System.out.println("=============== getPath 返回定义文件时使用的路径 ====================");
        System.out.println(f1.getPath());
        System.out.println(f4.getPath());


        System.out.println("=============== getName 获取名字 ====================");
        /**
         * 细节1: f1.txt  f1是文件名，txt是后缀名、扩展名
         * 细节2: 如果是文件夹，getName()方法返回的就是文件夹的名字；如果是文件，getName()方法返回的就是文件名
         */
        System.out.println(f1.getName()); //  f1.txt
        System.out.println(new File("/Users/test/BB").getName()); // BB

        System.out.println("================ lastModified 返回文件的最后修改时间（时间毫秒值） ==================");
        long l = f1.lastModified();
        Date date = new Date(l);
        String s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);

        System.out.println(f1.getPath()+" 的最后修改时间："+s);

    }
}

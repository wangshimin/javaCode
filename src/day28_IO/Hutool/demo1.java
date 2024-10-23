package day28_IO.Hutool;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class demo1 {
    public static void main(String[] args) {
    /*
        FileUtil类:
                file：根据参数创建一个file对象
                touch：根据参数创建文件

                writeLines：把集合中的数据写出到文件中，覆盖模式。
                appendLines：把集合中的数据写出到文件中，续写模式。
                readLines：指定字符编码，把文件中的数据，读到集合中。
                readLines：按照UTF-8的形式，把文件中的数据，读到集合中

                copy：拷贝文件或者文件夹
    */


        File file1 = FileUtil.file("myfile", "aaa", "bbb", "a.txt");
        System.out.println(file1);//myfile/aaa/bbb/a.txt

        File touch = FileUtil.touch(file1);
        System.out.println(touch);


        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");

        File file2 = FileUtil.writeLines(list, "myfile/aaa/bbb/a.txt", "UTF-8");
        System.out.println(file2);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("ddd");
        list2.add("eee");
        list2.add("fff");
        File file3 = FileUtil.appendLines(list2, "myfile/aaa/bbb/a.txt", "UTF-8");
        System.out.println(file3);


        List<String> list3 = FileUtil.readLines("myfile/aaa/bbb/a.txt", "UTF-8");
        System.out.println(list3);


    }
}


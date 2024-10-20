package day27_Exception.File.Test;

import java.io.File;
import java.io.IOException;

public class test1 {
    public static void main(String[] args) {
        //需求：在当前模块下的aaa文件夹中创建一个a.txt文件

        //1.创建a.txt的父级路径
        File file = new File("myfile/aaa");
        //2.创建父级路径
        //如果aaa是存在的，那么此时创建失败的。
        //如果aaa是不存在的，那么此时创建成功的。
        file.mkdirs();
        //3.拼接父级路径和子级路径
        File src = new File(file, "a.txt");
        try {
            boolean created = src.createNewFile();
            if (created) {
                System.out.println("文件创建成功");
            } else {
                System.out.println("文件已存在");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
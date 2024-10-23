package day29_IO.ObjectStream.Test;

import java.io.*;
import java.util.ArrayList;

public class test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
         需求：将多个自定义对象序列化到文件中，但是对象的个数不确定，该如何操作呢？
         */

        System.out.println(" ----------- 开始序列化多个对象啦 -----------");
        // 1.创建多个对象
        Student s1 = new Student("zhangsan", 23, "beijing");
        Student s2 = new Student("lisi", 24, "shanghai");
        Student s3 = new Student("wangwu", 25, "guangzhou");

        ArrayList<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        // 2.创建序列化输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myfile/testdemo1.ext"));

        // 3.写出数据
        oos.writeObject(list);

        // 4.释放资源
        oos.close();

        System.out.println(" ------------ 开始反序列化啦 -----------");

        // 5.创建反序列化流的对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myfile/testdemo1.ext"));

        // 6.读取数据
        ArrayList<Student> list2 = (ArrayList<Student>) ois.readObject();


        // 7.打印数据
        for (Student student : list2) {
            System.out.println(student);
        }

        // 8.释放资源
        ois.close();


    }
}

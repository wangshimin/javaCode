package day22_DataStructures.Collection;

import java.util.ArrayList;

public class A02 {
    public static void main(String[] args) {
        // 1.创建集合的对象
        ArrayList<Student> coll = new ArrayList<>();

        // 2.创建三个学生对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("lisi", 24);
        Student s3 = new Student("wangwu", 25);

        // 3.把学生对象添加到集合当中
        coll.add(s1);
        coll.add(s2);
        coll.add(s3);

        // 4.判断集合中某一个学生对象是否包含
        Student s4 = new Student("zhangsan", 23);
        // 如果同姓名和同年龄，就认为是同一个学生
        // 因为contains方法在底层依赖equals方法判断对象是否一致的
        // 默认使用Object类中的equals方法进行判断，此方法是依赖地址值进行判断的。
        // 不符合“如果同姓名和同年龄，就认为是同一个学生”此需求，因此需要在自定义类中重写equals方法就可以了。
        System.out.println(coll.contains(s4));
    }
}

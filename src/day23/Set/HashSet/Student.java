package day23.Set.HashSet;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;


    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }

    @Override
    // this:表示当前要添加的元素
    // o: 表示已经在红黑树中存在的元素

    // 返回值：
    // 负数 - 表示当前要添加的元素是小的，存左边
    // 正数 - 表示当前要添加的元素是大的，存右边
    // 0 - 表示当前要添加的元素已经存在，舍弃
    public int compareTo(Student o) {
        System.out.println("---------");
        System.out.println("this:"+this);
        System.out.println("o:"+o);
        if(this.age < o.age)
            System.out.println("存左边");
        else if(this.age > o.age)
            System.out.println("存右边");
        else
            System.out.println("舍弃");
        // 指定排序的规则
        // 只看年龄，按照年龄的升序进行排序
        return this.age - o.age;
    }
}

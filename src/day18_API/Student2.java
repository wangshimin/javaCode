package day18_API;

import java.util.Objects;

public class Student2 {
    private String name;
    private int age;

    public Student2() {
    }

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写之后的equals方法比较的就是对象内部的属性值了
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 stu = (Student2) o;
        return age == stu.age && Objects.equals(name, stu.name);
    }

    @Override
    public String toString() {
        return "Student2{name = "+ name +", age = "+ age +"}";
    }
}

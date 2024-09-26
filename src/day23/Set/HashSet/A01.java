package day23.Set.HashSet;

public class A01  {
    public static void main(String[] args) {
        /**
         * 哈希值 ： 对象的整数表现形式
         * 1. 如果没有重写hashCode方法，不同对象计算出的哈希值是不同的
         * 2. 如果已经重写hashCode方法，不同的对象只要属性值相同，计算出的哈希值就是一样的。
         * 3. 在小部分情况下，不同的属性值或不同的地址值计算出来的哈希值也有可能是一样的。（哈希碰撞）
         *
         */

        // 1.创建对象
        Student s1 = new Student("zhangsan", 23);
        Student s2 = new Student("zhangsan", 23);

        // 2.如果没有重写hashCode方法，不同对象计算出的哈希值是不同的
        //   如果已经重写hashCode方法，不同的对象只要属性值相同，计算出的哈希值就是一样的。
        System.out.println(s1.hashCode() == s2.hashCode());

        // 在小部分情况下，不同的属性值或不同的地址值计算出来的哈希值也有可能是一样的。
        // （哈希碰撞）
        System.out.println("abc".hashCode() == "acD".hashCode()); // true
    }
}

package day18_API;

public class ObjectDemo {
    /**
     * public String toString()             返回对象的字符串表示形式
     * public boolean equals(Object obj)    比较两个对象是否相等
     * public Object clone(int a)           对象克隆
     */
    public static void main(String[] args) {
        // 1.toString
        Object obj = new Object();
        System.out.println(obj.toString());// java.lang.Object@7b23ec81
        // toString方法的结论：
        // 如果我们打印一个对象，想要看到属性值的话，那么就重写toString方法就可以了。
        // 在重写的方法中，把对象的属性值进行拼接。

        String s = "abc";
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(s.equals(sb)); // false
        // 因为equals方法是被s调用的，而s是字符串
        // 所以equals要看String类中
        // 字符串中的equals方法，先判断参数是否为字符串
        // 如果是字符串，再比较内部的属性
        // 但是如果参数不是字符串，直接返回false


        System.out.println(sb.equals(s)); // false
        // 因为equals方法是被sb调用的，而sb是StringBuilder
        // 所以equals要看StringBuilder类中
        // 那么在StringBuilder当中，没有重写equals方法
        // 使用的是Object中的
        // 在Object当中默认是使用==号比较两个对象的地址值
        // 而这里的s和sb记录的地址值是不一样的，所以结果返回false


        // equals方法的结论：
        // 1. 如果没有重写equals方法，那么默认使用Object中的方法进行比较，就是比较两个对象的地址值是否相同。
        // 2.一般来说地址值对于我们意义不大，所以我们会重写，重写之后比较的就是对象内部的属性值了。
    }
}

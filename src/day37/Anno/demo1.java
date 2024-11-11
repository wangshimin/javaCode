package day37.Anno;

public class demo1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        method();

    }

    // 已过时的方式，还是可以继续使用的，但是一定会有替代解决方案
    @Deprecated
    public static void method(){
        System.out.println("看看我执行了吗");
    }
}

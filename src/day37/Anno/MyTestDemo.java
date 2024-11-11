package day37.Anno;

public class MyTestDemo {

    // 需求：程序运行之后，需要自动运行method1和method2
    @MyTest
    public void method1(){
        System.out.println("method1");
    }

    @MyTest
    public void method2(){
        System.out.println("method2");
    }

    public void method3(){
        System.out.println("method3");
    }
}

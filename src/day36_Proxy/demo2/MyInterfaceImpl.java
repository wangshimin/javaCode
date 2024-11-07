package day36_Proxy.demo2;
// 实现接口
public class MyInterfaceImpl implements MyInterface{

    @Override
    public void doSomething(String... args) {
        System.out.println("执行 doSomething 方法，参数: " + String.join(", ", args));
    }
}

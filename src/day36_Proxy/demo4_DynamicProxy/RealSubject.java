package day36_Proxy.demo4_DynamicProxy;
// 真实对象类
public class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("真实对象：处理请求。");
    }
}

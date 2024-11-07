package day36_Proxy.demo4_DynamicProxy;

import java.lang.reflect.Proxy;

/**
 * 使用动态代理
 *
 * 动态代理通过 InvocationHandler 来拦截方法调用
 * 并在调用前后加入了自定义的处理逻辑
 * 动态代理允许我们在运行时为任意接口生成代理对象
 *
 * 非常适合需要灵活扩展的场景
 */
public class demo {
    public static void main(String[] args) {
        RealSubject o = new RealSubject();
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                o.getClass().getInterfaces(),
                new DynamicProxyHandler(o)
        );
        proxyInstance.request();
    }
}

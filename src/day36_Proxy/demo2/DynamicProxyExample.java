package day36_Proxy.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类
 */
public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建目标对象
        MyInterfaceImpl target = new MyInterfaceImpl();

        // 创建动态代理对象
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                MyInterface.class.getClassLoader(),
                new Class[]{MyInterface.class},
                new MyInvocationHandler(target)
        );

        // 通过代理对象调用方法
        proxy.doSomething("Hello", "World"); // 通过代理对象调用 doSomething 方法，实际执行的是 MyInvocationHandler 中的 invoke 方法。
    }

    // 静态内部类
    // 它实现了 InvocationHandler 接口，用于处理动态代理的方法调用。
    // 它包含一个目标对象，通过反射机制调用目标对象的方法，并返回结果
    // 由于它是静态的，所以可以独立于 DynamicProxyExample 类的实例存在，可以直接通过 DynamicProxyExample.MyInvocationHandler 来创建实例。
    static class MyInvocationHandler implements InvocationHandler {
        private final Object target;

        public MyInvocationHandler(Object target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            // 在方法调用前执行的操作
            System.out.println("方法调用前的日志记录");

            // 调用目标对象的方法
            Object result = method.invoke(target, args);

            // 在方法调用后执行的操作
            System.out.println("方法调用后的日志记录");

            return result;
        }

    }
}

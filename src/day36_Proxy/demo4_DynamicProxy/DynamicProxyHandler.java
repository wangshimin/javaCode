package day36_Proxy.demo4_DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 动态处理器
public class DynamicProxyHandler implements InvocationHandler {
    private  Object obj;

    public DynamicProxyHandler(Object obj){
        this.obj = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理：在真实对象之前执行操作。");
        Object result = method.invoke(obj, args);
        System.out.println("代理：在真实对象之后执行操作。");
        return result;
    }
}

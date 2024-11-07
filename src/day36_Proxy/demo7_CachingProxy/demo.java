package day36_Proxy.demo7_CachingProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 缓存代理
 *
 * 场景：代理模式可以缓存频繁访问的结果，减少系统负载并提升响应速度，例如缓存数据库查询结果。
 */
public class demo {
    public static void main(String[] args) {
        // 创建目标对象
        DataService o = new DataServiceImpl();
        // 创建动态代理对象
        DataService proxy = (DataService) Proxy.newProxyInstance(
                DataService.class.getClassLoader(),
                new Class[]{DataService.class},
                new CacheInvocationHandler(o)
        );

        // 通过代理对象调用方法
        System.out.println(proxy.fetchData(1));// 第一次调用，会执行实际的 fetchData 方法
        System.out.println(proxy.fetchData(1));// 第二次调用，从缓存中获取数据
        System.out.println(proxy.fetchData(2));// 第一次调用，会执行实际的 fetchData 方法
        System.out.println(proxy.fetchData(2));// 第二次调用，从缓存中获取数据
    }

    private static class CacheInvocationHandler implements InvocationHandler {
        private final DataService target;
        private final Map<Integer, String> cache = new HashMap<>();

        public CacheInvocationHandler(DataService target) {
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.getName().equals("fetchData") && args.length == 1) {
                Integer id = (Integer) args[0];
                if (cache.containsKey(id)){
                    System.out.println("从缓存中获取数据");
                    return cache.get(id);
                } else {
                    System.out.println("从实际方法中获取数据");
                    String result = (String)method.invoke(target, args);
                    cache.put(id, result);
                    return result;
                }
            }
            return method.invoke(target, args);
        }
    }
}

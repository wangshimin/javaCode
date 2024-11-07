package day36_Proxy.demo3_StaticProxy;

/**
 * 静态代理实现
 *
 * ProxyDemo 类通过组合的方式持有 RealSubject 的实例
 * 并在 request 方法的执行前后分别加入了权限检查和日志记录功能
 * 静态代理的代理行为在编译时确定
 * 适合结构固定的场景。
 */
// 使用代理
public class Demo {
    public static void main(String[] args) {
        RealSubject o = new RealSubject();
        ProxyDemo proxy = new ProxyDemo(o);
        proxy.request();
    }
}

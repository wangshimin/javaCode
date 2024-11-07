package day36_Proxy.demo3_StaticProxy;
// 代理类
public class ProxyDemo implements Subject{

    private RealSubject realSubject;

    public ProxyDemo(RealSubject realSubject)
    {
        this.realSubject = realSubject;
    }
    @Override
    public void request() {
        System.out.println("代理：在真实对象之前检查权限。");
        realSubject.request();
        System.out.println("代理：在真实对象之后记录日志。");
    }
}

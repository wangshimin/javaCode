package day36_Proxy.demo5_ProtectionProxy;

public class RealSubject implements Subject{
    @Override
    public void request(String userRole) {
        System.out.println(userRole + " 访问：执行敏感操作");
    }
}

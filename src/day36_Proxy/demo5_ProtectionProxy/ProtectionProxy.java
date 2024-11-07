package day36_Proxy.demo5_ProtectionProxy;
// 保护代理类
public class ProtectionProxy implements Subject{
   private RealSubject obj;

    public ProtectionProxy(RealSubject obj) {
        this.obj = obj;
    }

    @Override
    public void request(String userRole) {
        if ("Admin".equals(userRole)){
            obj.request(userRole);
        } else {
            System.out.println("访问被拒绝："+userRole+"没有权限");
        }
    }
}

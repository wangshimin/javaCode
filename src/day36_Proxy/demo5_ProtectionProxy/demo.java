package day36_Proxy.demo5_ProtectionProxy;

/**
 * 保护代理
 *
 * ProtectionProxy 类根据用户的角色决定是否允许访问真实对象
 * 只有管理员（Admin）角色的用户才能执行操作
 * 其他角色则被拒绝访问
 *
 * 这种模式非常适用于权限控制系统
 * 场景：在权限控制系统中，通过代理来控制对敏感数据或操作的访问权限，不同用户的权限判断就是一个典型应用；
 */
public class demo {
    public static void main(String[] args) {
        RealSubject o = new RealSubject();
        ProtectionProxy proxy = new ProtectionProxy(o);

        proxy.request("Admin"); // 输出：Admin 访问：执行敏感操作
        proxy.request("Guest"); // 输出：访问被拒绝：Guest没有权限
    }
}

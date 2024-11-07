package day36_Proxy.demo6_VirtualProxy;

/**
 * 使用虚拟代理
 *
 * VirtualProxy 控制了对 HeavyResource 的访问
 * 只有在第一次调用 load 方法时才会加载实际资源
 * 后续调用不会再次加载
 *
 * 这种模式非常适合需要优化性能的场景
 * 场景：当创建昂贵对象时，虚拟代理可以延迟对象的创建，直到真正需要时再进行实例化，如大型图片的延迟加载
 */
public class demo {
    public static void main(String[] args) {
        Resource o = new VirtualProxy();
        o.load(); // 首次调用会加载数据
        o.load(); // 第二次调用不会再次加载数据
    }
}

package day36_Proxy.demo6_VirtualProxy;

/**
 * 虚拟代理类
 */
public class VirtualProxy implements Resource{
    private HeavyResource obj;
    @Override
    public void load() {
        if (obj == null) {
            obj = new HeavyResource();
            obj.load();
        }
        System.out.println("资源已加载，执行操作。");
    }
}

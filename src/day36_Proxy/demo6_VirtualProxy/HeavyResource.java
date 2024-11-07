package day36_Proxy.demo6_VirtualProxy;

/**
 * 重型资源类
 */
public class HeavyResource implements Resource{
    @Override
    public void load() {
        System.out.println("加载大量数据...");
    }
}

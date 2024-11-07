package day36_Proxy.demo1;

public interface Star {
    // 我们可以把所有想要被代理的方法定义在接口当中

    /**
     * 唱歌
     * @param name
     * @return
     */
    public abstract String sing(String name);

    /**
     * 跳舞
     */
    public abstract void dance();
}

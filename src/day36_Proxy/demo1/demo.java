package day36_Proxy.demo1;

public class demo {
    /*
        需求：
            外面的人想要大明星唱一首歌
             1. 获取代理的对象
                代理对象 = ProxyUtil.createProxy(大明星的对象);
             2. 再调用代理的唱歌方法
                代理对象.唱歌的方法("只因你太美");
     */
    public static void main(String[] args) {
        //1. 获取代理的对象
        BigStar bigStar = new BigStar("刘德华");
        Star proxy = ProxyUtil.createProxy(bigStar);

        // 2. 调用代理的唱歌方法
        String result = proxy.sing("17岁");
        System.out.println(result);
    }
}

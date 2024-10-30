package day32_Thread.Thread_Pool.Demo2;

public class d2 {
    public static void main(String[] args) {
        // 向虚拟机返回可用处理器的数目
        int count = Runtime.getRuntime().availableProcessors();
        System.out.println(count);
    }
}

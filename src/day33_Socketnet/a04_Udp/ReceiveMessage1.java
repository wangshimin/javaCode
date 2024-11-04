package day33_Socketnet.a04_Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketAddress;

public class ReceiveMessage1 {
    public static void main(String[] args) throws IOException {
        /*
        组播接收端代码
         */

        // 1.创建multicastSocket对象
        MulticastSocket ms = new MulticastSocket(SendMessage.port);

        // 2.创建InetAddress对象，封装组播地址
        // 将当前本机，添加到组播地址中
        InetAddress address = InetAddress.getByName("224.0.0.1");


        ms.joinGroup(address);

        // 3.创建DatagramPacket对象，接收数据
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

        // 4.接收数据
        ms.receive(dp);

        // 5.解析数据
        byte[] data = dp.getData();
        int len = dp.getLength();
        String ip = dp.getAddress().getHostAddress();
        String name = dp.getAddress().getHostName();

        System.out.println("ip为"+ip + "，主机名为："+ name + "的人，发送了数据：" + new String(data, 0, len));

        // 6.释放资源
        ms.close();

    }
}

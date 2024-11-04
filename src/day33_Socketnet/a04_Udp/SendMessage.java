package day33_Socketnet.a04_Udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class SendMessage {
    public static int port = 10000;
    public static void main(String[] args) throws IOException {
        /*
        组播发送端代码
         */

        // 1.创建MuticastSocket对象
        MulticastSocket ms = new MulticastSocket();

        // 2.创建DatagramPacket对象，封装数据
        String s = "大家好呀#！!";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.0.1");

        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);

        // 3.调用MuticastSocket对象的send方法，发送数据
        ms.send(dp);

        // 4.释放资源
        ms.close();
    }
}

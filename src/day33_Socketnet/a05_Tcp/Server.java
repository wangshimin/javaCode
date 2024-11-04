package day33_Socketnet.a05_Tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /*
        TCP协议，接收数据
         */

        // 1.创建对象SercerSocket
        ServerSocket ss = new ServerSocket(10002);
        System.out.println("服务器已启动，等待接收数据...");

        // 2.监听客户端的连接
        Socket socket = ss.accept();

        // 3.从连接通道中获取输入流读取数据
        InputStream is = socket.getInputStream();
        // 把输入流转变成可以读取中文的字符流
        InputStreamReader isr = new InputStreamReader(is);
        // 4.把字符流变成字符缓冲流，可以提高读取字符的效率
        BufferedReader br = new BufferedReader(isr);
        int b;
        while( (b = br.read()) != -1) {
            System.out.print((char)b);
        }

        System.out.println("数据接收完毕");

        // 5.释放资源
        socket.close();
        ss.close();
    }
}

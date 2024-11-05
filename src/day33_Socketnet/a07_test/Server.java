package day33_Socketnet.a07_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    /**
     * (需求)
     * 客户端：多次发送数据
     * 服务器：接收多次接收数据，并打印
     */
    public static void main(String[] args) throws IOException {

        // 1.创建对象并绑定10002端口
        ServerSocket serverSocket = new ServerSocket(10002);

        // 2.等待客户端来连接
        Socket socket = serverSocket.accept();

        // 3.从连接通道中获取输入流读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int b;
        while ( (b = br.read()) != -1) {
            System.out.print((char)b);
        }

        // 4.释放资源
        socket.close();
        serverSocket.close();
    }
}

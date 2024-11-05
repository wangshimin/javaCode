package day34_Socketnet_HomeWork.Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Properties;

public class Server {

    static ArrayList<Socket> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10014);


        // 1.把本地文件中正确的用户名和密码获取到
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/day34_Socketnet_HomeWork/servicedir/userinfo.txt");
        prop.load(fis);
        fis.close();

        // 2.只要来了一个客户端，就开一条线程处理
        while (true) {
            // 监听客户端的连接，接收客户端的连接，阻塞方法，如果没有客户端连接，程序会一直阻塞，直到有客户端连接
            Socket socket = serverSocket.accept();
            System.out.println("有客户端连接了");
            new Thread(new MyRunnable(socket, prop)).start();
        }
    }
}

package day33_Socketnet.a07_test;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    /**
     * (需求)
     * 客户端：多次发送数据
     * 服务器：接收多次接收数据，并打印
     */
    public static void main(String[] args) throws IOException {

        // 1.创建Socket对象并连接服务器
        Socket socket = new Socket("127.0.0.1", 10002);

        // 2.写出数据
        Scanner scanner = new Scanner(System.in);
        OutputStream os = socket.getOutputStream();

        while(true) {
            System.out.println("请输入您要发送的数据：");
            String str = scanner.nextLine();
            if ("886".equals(str)) {
                break;
            }
            os.write(str.getBytes());
        }

        // 3.释放资源
        os.close();
        socket.close();
    }
}

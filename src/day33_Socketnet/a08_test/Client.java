package day33_Socketnet.a08_test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    /*
    （需求:接收并反馈）
    客户端：发送一条数据，接收服务端反馈的消息并打印
    服务器：接收数据并打印，再给客户端反馈消息
     */
    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象，并连接服务端
        Socket socket = new Socket("127.0.0.1", 10003);

        // 2.写出数据
        String str = "见到你好高兴！";
        OutputStream os = socket.getOutputStream();
        os.write(str.getBytes());

        // 3.写出一个结束标记
        socket.shutdownOutput();

        // 4.接收服务端回写的数据
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        int b;
        while( (b = isr.read()) != -1 ){
            System.out.print((char)b);
        }

        // 5.释放资源
        os.close();
        socket.close();
    }
}

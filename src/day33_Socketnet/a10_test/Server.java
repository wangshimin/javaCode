package day33_Socketnet.a10_test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    /*
    (需求：上传文件，文件名不重复)
    客户端：将本地文件上传到服务器。接收服务器的反馈。
    服务器：接收客户端上传的文件，上传完毕之后给出反馈。
     */
    public static void main(String[] args) throws IOException {

        // 1.创建对象并绑定端口
        ServerSocket serverSocket = new ServerSocket(10010);

        // 2.等待客户端来连接
        System.out.println("等待客户端连接...");
        Socket socket = serverSocket.accept();
        System.out.println("客户端连接成功");

        // 3.读取数据并保存到本地文件中
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        String name = UUID.randomUUID().toString().replace("-", "");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("src/day33_Socketnet/serverdir/" + name + ".jpg"));
        int len;
        byte[] bytes = new byte[1024];
        while ( (len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        // 往客户端写出结束标记
        socket.shutdownInput();

        // 4.回写数据，反馈给客户端
        // socket.getOutputStream() 返回的是字节输出流
        // 使用OutputStreamWriter 把字节输出流转换成字符输出流
        // 再使用BufferedWriter来包裹可直接使用中文
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bw.write("上传成功");
        bw.newLine();
        bw.flush();

        // 5.释放资源
        socket.close();
        serverSocket.close();
    }
}

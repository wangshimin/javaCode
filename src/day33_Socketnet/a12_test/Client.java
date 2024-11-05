package day33_Socketnet.a12_test;

import java.io.*;
import java.net.Socket;

public class Client {
    /*
    需求：上传文件（线程池优化）
    频繁创建线程并销毁非常浪费系统资源，所以需要用线程池优化
     */
    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象，并连接服务器
        Socket socket = new Socket("127.0.0.1", 10012);

        // 2.读取本地文件中的数据，并写到服务器中
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("src/day33_Socketnet/clientdir/a.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1 ){
            bos.write(bytes, 0, len);
        }
        bos.flush();

        // 往服务器写出结束标记
        socket.shutdownOutput();

        // 3.接收服务器的回写数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line = br.readLine();
        System.out.println(line);

        // 4.释放资源
        socket.close();
    }
}

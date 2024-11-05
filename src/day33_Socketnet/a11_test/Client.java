package day33_Socketnet.a11_test;

import java.io.*;
import java.net.Socket;

public class Client {
    /*
    （需求：多线程版的上传文件）
    客户端：将本地文件上传到服务器。接收服务器的反馈。
    服务器：接收客户端上传的文件，上传完毕之后给出反馈。
    想要服务器不停止，能接收很多用户上传的图片，该怎么做呢？
    提示：可以用循环或者多线程，但是循环不合理，最优解法是（循环+多线程）改写
     */
    public static void main(String[] args) throws IOException {
        // 1.创建Socket对象，并连接服务器
        Socket socket = new Socket("127.0.0.1", 10011);

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

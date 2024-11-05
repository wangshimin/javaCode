package day33_Socketnet.a11_test;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class MyRunnable implements Runnable {
    Socket socket;

    public MyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 5.释放资源
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}

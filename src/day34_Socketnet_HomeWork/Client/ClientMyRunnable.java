package day34_Socketnet_HomeWork.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientMyRunnable implements Runnable {
    Socket socket;

    public ClientMyRunnable(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 循环，重复的接收服务器发送过来的数据
            while (true) {
                // 接收服务器发送过来的聊天记录
                String msg = br.readLine();
                System.out.println(msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

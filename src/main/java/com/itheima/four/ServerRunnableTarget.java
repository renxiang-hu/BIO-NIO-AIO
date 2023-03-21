package com.itheima.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerRunnableTarget implements Runnable {

    private Socket socket;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while ((message = bufferedReader.readLine()) != null) {
                System.out.println("服务器端接收信息：" + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

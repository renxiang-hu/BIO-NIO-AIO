package com.itheima.three;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadReader extends Thread{

    private Socket socket;

    public ServerThreadReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //从socket对象中得到字节输入流
            InputStream inputStream = socket.getInputStream();
            //使用缓冲字符输入流包装字节输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null){
                System.out.println("服务器端接收到的消息：" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

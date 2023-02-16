package com.itheima.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：服务端可以反复的接收信息，客户端可以反复的发送消息
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("===服务端启动===");
        try {
            //定义一个ServerSocket对象进行服务端的接口注册
            ServerSocket serverSocket = new ServerSocket(9999);
            //监听客户端Socket连接请求
            Socket accept = serverSocket.accept();
            //从socket管道中得到一个字节输入流对象
            InputStream inputStream = accept.getInputStream();
            //把输入流包装成缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while ((message=bufferedReader.readLine()) != null) {
                System.out.println("服务器接收到："+ message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

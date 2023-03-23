package com.itheima.BIO.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：客户端发送消息，服务端接收消息
 */
public class Server {
    public static void main(String[] args) {
        try {
            //1、定义一个ServerSocket对象进行服务端的端口注册
            ServerSocket serverSocket = new ServerSocket(9999);
            //2、监听客户端Socket链接请求
            Socket socket = serverSocket.accept();
            //3、从socket管道中得到一个字节输入流对象
            InputStream inputStream = socket.getInputStream();
            //4、把字节输入流包装成一个缓冲字符输入流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("服务端接收到：" + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

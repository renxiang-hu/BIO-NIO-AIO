package com.itheima.three;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *  目标：实现服务端可以同时接收多个客户端的socket通信需求
 *  思路：服务端每接收到一个客户端的socket对象请求之后都交给一个独立的线程来处理客户端数据交互需求
 */
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("===服务端启动===");
            //1.服务端注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            //2.定义一个死循环，用于不断接受客户端的socket连接请求
            while (true){
                Socket socket = serverSocket.accept();
                //3.创建一个独立的线程处理与客户端socket通信请求
                new ServerThreadReader(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

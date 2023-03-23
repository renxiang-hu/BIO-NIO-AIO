package com.itheima.BIO.three;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：实现服务端可以同时接收多个客户端的Socket通信请求
 * 思路：是服务端每接收到一个客户端socket请求对象之后都交给一个独立的线程来处理客户端的数据
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true) {
                Socket accept = serverSocket.accept();
                new ServerThreadReader(accept).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.itheima.five;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：服务端开发，可以实现接收客户端任意类型文件，并保存到服务端磁盘
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8888);
            Socket accept = socket.accept();
            new ServerReaderThread(accept).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

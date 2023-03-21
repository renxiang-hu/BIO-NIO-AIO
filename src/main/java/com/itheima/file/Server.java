package com.itheima.file;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 目标：服务端开发，可以实现接收客户端的任意类型文件，并保存到服务器端的磁盘
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket = new ServerSocket(8888);
            while (true){
                Socket accept = socket.accept();
                //交给一个独立的线程来处理与这个客户端的文件通信需求
                new ServerReaderThread(accept).start();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

package com.itheima.four;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *  开发实现伪异步通信架构
 */
public class server {
    public static void main(String[] args) {
        try{
            //1.注册端口
            ServerSocket serverSocket = new ServerSocket(9999);
            //2.定义一个循环接收客户端的连接请求
            //初始化线程池对象
            HandlerSocketServerPool pool = new HandlerSocketServerPool(3,10);
            while (true){
                Socket socket = serverSocket.accept();
                //把socket对象交给一个线程池进行处理
                Runnable target = new ServerRunnableTarget(socket);
                pool.execute11(target);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

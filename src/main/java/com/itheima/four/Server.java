package com.itheima.four;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            HandlerSocketServerPool pool = new HandlerSocketServerPool(3,10);
            while (true) {
                Socket accept = serverSocket.accept();
                ServerRunnableTarget serverRunnableTarget = new ServerRunnableTarget(accept);
                pool.execute(serverRunnableTarget);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

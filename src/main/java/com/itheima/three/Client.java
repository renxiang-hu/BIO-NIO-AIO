package com.itheima.three;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //请求与服务器端的socket连接请求
        Socket socket = new Socket("127.0.0.1",9999);
        //得到一个打印流
        PrintStream printStream = new PrintStream(socket.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        //使用循环不断发送消息给服务端接收
        while (true){
            System.out.println("请说：");
            String msg = scanner.nextLine();
            printStream.println(msg);
            printStream.flush();
        }
    }
}

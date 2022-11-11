package com.itheima.two;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建socket对象请求服务端的连接
        Socket socket = new Socket("127.0.0.1", 9999);
        //从socket对象中获得一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //把字节输出流包装成打印流
        PrintStream printStream = new PrintStream(outputStream);
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请说：");
            String msg = sc.nextLine();
            printStream.println(msg);
            printStream.flush();
        }

    }
}

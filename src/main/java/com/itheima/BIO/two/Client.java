package com.itheima.BIO.two;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws Exception {
        //1.创建Socket对象请求服务端的连接
        Socket socket = new Socket("127.0.0.1", 9999);
        //2.从Socket对象中获取一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //3.把字节输出流包装成打印流
        PrintStream printStream = new PrintStream(outputStream);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("请说：");
            String s = scanner.nextLine();
            printStream.println(s);

        }
    }
}

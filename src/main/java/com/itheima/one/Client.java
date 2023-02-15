package com.itheima.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1、创建Socket对象请求服务端的链接
        Socket socket = new Socket("127.0.0.1",9999);
        //2、从Socket对象中获取一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //3、把字节输出流包装成一个打印流
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("hello world 服务器");
        printStream.flush();
    }
}

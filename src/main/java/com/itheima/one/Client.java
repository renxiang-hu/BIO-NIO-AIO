package com.itheima.one;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建socket对象请求服务端的连接
        Socket socket = new Socket("127.0.0.1", 9999);
        //从socket对象中获得一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //把字节输出流包装成打印流
        PrintStream printStream = new PrintStream(outputStream);
        printStream.print("hello world 服务器！");
        printStream.flush();
    }
}

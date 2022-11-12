package com.itheima.five;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 目标：实现客户端上传任意类型的文件数据给服务端保存起来
 */
public class Client {
    public static void main(String[] args) {
        try {
            //1.请求与服务端的socket连接
            Socket socket = new Socket("127.0.0.1",8888);
            //2.把字节输出流包装成一个数据输出流
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            //3.先发送上传文件的后缀给服务端
            dataOutputStream.writeUTF(".jpeg");
            //4.把文件数据发送给服务端进行接收
            InputStream inputStream = new FileInputStream("/Users/hurenxiang/Desktop/java.jpeg");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > 0){
               dataOutputStream.write(buffer,0,len);
            }
            dataOutputStream.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

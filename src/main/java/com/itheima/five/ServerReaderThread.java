package com.itheima.five;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerReaderThread extends Thread{

    private Socket socket;

    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //1.得到一个数据输入流读取客户端发送过来的数据
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //2.读取客户端发送过来的文件类型
            String suffix = dataInputStream.readUTF();
            System.out.println("服务端已经成功接收到文件类型："+suffix);
            //3.定义一个字节输出管道负责把客户端发送过来的文件数据写出去
            OutputStream outputStream = new FileOutputStream("/Users/hurenxiang/Desktop/测试上传文件/pic"+ UUID.randomUUID().toString()+suffix);
            //4.从数据输入流中读取文件类型，写出到字节输出流中去
            byte[] buffer = new byte[1024];
            int len;
            while ((len = dataInputStream.read(buffer)) > 0){
                outputStream.write(buffer,0,len);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

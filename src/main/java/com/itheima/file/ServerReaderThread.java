package com.itheima.file;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerReaderThread extends Thread {

    private Socket socket;

    public ServerReaderThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            //1.得到一个数据输入流来读取客户端发送过来的数据
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            //2.读取客户端发送过来的文件类型
            String suffix = dataInputStream.readUTF();
            //3.定义一个字节输出管道，负责把客户端发送过来的数据写进去
            OutputStream outputStream = new FileOutputStream("/Users/hurenxiang/Desktop/" + UUID.randomUUID().toString()+suffix);
            //4.从数据输入流中读取文件数据，写出到字节输出流中去
            byte[] buffer = new byte[1024];
            int len;
            while ((len = dataInputStream.read(buffer)) > 0) {
                outputStream.write(buffer,0,len);
            }
            outputStream.close();
            System.out.println("服务端接收文件保存成功！");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}

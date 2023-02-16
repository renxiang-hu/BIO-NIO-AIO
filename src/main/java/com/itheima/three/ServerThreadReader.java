package com.itheima.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThreadReader extends Thread{

    private Socket socket;

    public ServerThreadReader(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String message;
            while ((message=bufferedReader.readLine())!=null){
                System.out.println("服务器接收信息："+ message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

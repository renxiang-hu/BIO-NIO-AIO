package com.itheima.NIO;

import java.nio.ByteBuffer;

public class bufferTest1 {
    public static void main(String[] args) {
//        ByteBuffer buffer = ByteBuffer.allocate(10);
//        System.out.println(buffer.position()); //0
//        System.out.println(buffer.limit()); //10
//        System.out.println(buffer.capacity()); //10
//        System.out.println("---------------------");
//
//        String name = "itheima";
//        buffer.put(name.getBytes());
//        System.out.println(buffer.position()); //7
//        System.out.println(buffer.limit()); //10
//        System.out.println(buffer.capacity()); //10
//        System.out.println("---------------------");
//
//        buffer.clear();
//        System.out.println(buffer.position());
//        System.out.println(buffer.limit());
//        System.out.println(buffer.capacity());
//        System.out.println((char) buffer.get());
//        System.out.println("---------------------");

        //定义一个缓冲区
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        String n = "itheima";
        byteBuffer1.put(n.getBytes());
        byteBuffer1.flip();

        byte[] bytes = new byte[2];
        byteBuffer1.get(bytes);
        String rs = new String(bytes);
        System.out.println(rs);
        System.out.println(byteBuffer1.position());
        System.out.println(byteBuffer1.limit());
        System.out.println(byteBuffer1.capacity());
        System.out.println((char) byteBuffer1.get());
        System.out.println("---------------------");

        byteBuffer1.mark();
    }
}

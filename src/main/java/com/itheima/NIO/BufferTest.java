package com.itheima.NIO;

import java.nio.ByteBuffer;

/**
 * 目标：对缓冲区Buffer的常用API进行案例分析
 */

public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("---------------------");

        //put往缓存里面加数据
        String name = "itheima";
        buffer.put(name.getBytes());
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("---------------------");

        //flip为将缓存区的界限设置为当前位置，并将当前位置设置为0，可读模式
        buffer.flip();
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("---------------------");

        //get数据的读取
        char ch = (char) buffer.get();
        System.out.println(ch);
        System.out.println(buffer.position());
        System.out.println(buffer.limit());
        System.out.println(buffer.capacity());
        System.out.println("---------------------");
    }
}

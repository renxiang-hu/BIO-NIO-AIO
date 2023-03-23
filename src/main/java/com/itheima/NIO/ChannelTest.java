package com.itheima.NIO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelTest {

    /**
     * 写
     */
    @Test
    public void write() {
        try {
            //1.字节输出流通向目标文件
            FileOutputStream fos = new FileOutputStream("data01.txt");
            //2.得到字节输出流对应的通道Channel
            FileChannel channel = fos.getChannel();
            //3.分配缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);
            allocate.put("hello,renxiang".getBytes());
            //4.切换成写模式
            allocate.flip();
            channel.write(allocate);
            channel.close();
            System.out.println("已经写数据到文件中");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读
     * @throws Exception
     */
    @Test
    public void read() throws Exception {
        //1.定义一个文件字节输入流与源文件接通
        FileInputStream fis = new FileInputStream("data011.txt");
        //2.需要得到文件字节输入流的文件通道
        FileChannel channel = fis.getChannel();
        //3.定义一个缓冲区
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        //4.读取文件到缓冲区
        channel.read(allocate);
        allocate.flip();
        //5.读出缓冲区的数据并输出
        String rs = new String(allocate.array(),0,allocate.remaining());
        System.out.println(rs);
    }

    /**
     * 文件拷贝
     * @throws Exception
     */
    @Test
    public void copy() throws Exception {
        //源文件
        File srcFile = new File("/Users/hurenxiang/Desktop/me.jpeg");
        File destFile = new File("/Users/hurenxiang/Desktop/dest/me_didi.jpeg");
        //得到字节输出流，字节输入流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        //获得文件通道
        FileChannel fisChannel = fis.getChannel();
        FileChannel fosChannel = fos.getChannel();
        //分配缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int read = fisChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            fosChannel.write(byteBuffer);
        }
        fosChannel.close();
        fisChannel.close();
        System.out.println("复制文件成功");
    }

    /**
     * 数据的分散与聚集操作
     */
    @Test
    public void SeparAndAllo() throws Exception {
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("data02.txt");
        FileChannel fosChannel = fos.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {byteBuffer,byteBuffer1};

        fisChannel.read(buffers);

        for (ByteBuffer buffer : buffers){
            buffer.flip();
        }
        fosChannel.write(buffers);
        fosChannel.close();
        fisChannel.close();
        System.out.println("文件复制！！！");
    }

    /**
     * transferFrom用法
     * @throws Exception
     */
    @Test
    public void transferFrom() throws Exception {
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("data03.txt");
        FileChannel fosChannel = fos.getChannel();

        fosChannel.transferFrom(fisChannel,fisChannel.position(),fisChannel.size());
        fosChannel.close();
        fisChannel.close();
        System.out.println("文件data03.txt复制成功");
    }

    @Test
    public void transferTo() throws Exception {
        FileInputStream fis = new FileInputStream("data01.txt");
        FileChannel fisChannel = fis.getChannel();

        FileOutputStream fos = new FileOutputStream("data04.txt");
        FileChannel fosChannel = fos.getChannel();

        fisChannel.transferTo(fisChannel.position(),fisChannel.size(),fosChannel);
        fosChannel.close();
        fisChannel.close();
        System.out.println("文件data04.txt复制成功");
    }



}

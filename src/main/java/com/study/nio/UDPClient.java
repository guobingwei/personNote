package com.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * DatagramChannel是一个能收发UDP包的通道
 * Created by guobingwei on 2016/7/4.
 */
public class UDPClient {
    DatagramChannel channel;
    public void init() throws IOException {
        // DatagramChannel 的打开方式：
        channel = DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(9999));
        /*// 连接到特定的地址
        channel.connect(new InetSocketAddress("jenkov.com", 80));
        int bytesRead = channel.read(buf);
        int bytesWritten = channel.write(buf);*/
    }

    public void send() throws IOException {
        // 发送数据
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();

        int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
    }

    public void receive() throws IOException {
        // 接收数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        channel.receive(buf);
    }

    public static void  main(String [] args) throws IOException {
        UDPClient u = new UDPClient();
        u.init();
        u.send();
    }
}

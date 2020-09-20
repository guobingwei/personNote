package com.dm.yc.std.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 客户端用SocketChannel
 * Created by guobingwei on 2016/7/4.
 */
public class SocketClient {

    public void start() {

        SocketChannel socketChannel;

        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));

            String newData = "test" + System.currentTimeMillis();
            ByteBuffer buf = ByteBuffer.allocate(48);
            buf.clear();
            buf.put(newData.getBytes());

            while (buf.hasRemaining()) {
                socketChannel.write(buf);
            }

            System.out.println("客戶端發送完畢");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String [] args) {
        new SocketClient().start();
    }
}

package com.study.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * SocketChannel
 * Created by guobingwei on 2016/7/4.
 */
public class SocketChannelTest {

    public void init() throws IOException {
        // 打开 SocketChannel
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("dev.chuang.ba", 80));

        // 从 SocketChannel 读取数据
        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = socketChannel.read(buf);

    }
}

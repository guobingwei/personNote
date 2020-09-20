package com.dm.yc.std.study.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Java NIO 管道是2个线程之间的单向数据连接。Pipe有一个source通道和一个sink通道。数据会被写到sink通道，从source通道读取。
 * Created by guobingwei on 2016/7/4.
 */
public class PipeClient {
    public void init() throws IOException {

        // 通过Pipe.open()方法打开管道
        Pipe pipe = Pipe.open();

        // 要向管道写数据，需要访问sink通道。像这样：
        Pipe.SinkChannel sinkChannel = pipe.sink();

        // 通过调用SinkChannel的write()方法，将数据写入SinkChannel,像这样：
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        // 取管道的数据，需要访问source通道，像这样：
        Pipe.SourceChannel sourceChannel = pipe.source();

        // 调用source通道的read()方法来读取数据，像这样：
        int bytesRead = sourceChannel.read(buf);
    }
}

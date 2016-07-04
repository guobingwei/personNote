package com.study.nio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * 服务端用普通的Socket
 * Created by guobingwei on 2016/7/4.
 */
public class SocketServer {

    public void start() throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        System.out.println("server start……");

        while (true) {
            Socket s = ss.accept();
            String ip = s.getInetAddress().getHostAddress();

            System.out.println(ip + " - connected");

            SocketChannel channel = s.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(48);
            int len = channel.read(buff);

            while (len != -1) {
                buff.flip();
                System.out.println(buff.get());
                channel.read(buff);
            }

            // 关闭客户端
            s.close();
        }
    }

    public static void main(String [] args) throws IOException {
        new SocketServer().start();
    }
}

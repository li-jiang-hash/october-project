package com.aaa.day3Net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @Author: 江Sir
 * @Date: 2022/10/10 15:33
 * @Description:
 * @Since version:  2022.10
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //1开启服务器
            serverSocket = new ServerSocket(2157);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress() + "链接了");
                new ServerSocketThread(socket).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

package com.aaa.day3Net;

import java.io.*;
import java.net.Socket;

/*
 * @Author: 江Sir
 * @Date: 2022/10/10 15:37
 * @Description:
 * @Since version:  2022.10
 */
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        while (true) {

            try {
                //1.连接服务器
                socket = new Socket("lj", 2157);
                //4.接收服务器发过来的数据
                //获取输入流
                InputStream is = socket.getInputStream();
                //为了逐行读取把字节流转换成BufferedReader
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String welcomeMsg = br.readLine();
                System.out.println("welcomeMsg:"+welcomeMsg);


                //5.客户端向服务器端发消息
                //键盘输入
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                //获取输出流
                OutputStream os = socket.getOutputStream();
                //为逐行输出消息，把字节流转换成打印流且自动刷新
                PrintWriter pw = new PrintWriter(os, true);


                String line = null;
                System.out.print("请输入留言:");
                while (!(line = input.readLine()).equals("exit")) {
                    System.out.print("请输入留言:");
                    pw.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (socket != null)
                        socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

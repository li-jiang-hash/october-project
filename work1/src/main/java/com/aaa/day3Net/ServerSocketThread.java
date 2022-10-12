package com.aaa.day3Net;

import java.io.*;
import java.net.Socket;
import java.util.Random;

/*
 * @Author: 江Sir
 * @Date: 2022/10/10 16:41
 * @Description:
 * @Since version:  2022.10
 */
public class ServerSocketThread extends Thread{
    private Socket socket;
    public ServerSocketThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        System.out.println(socket.getRemoteSocketAddress()+":已连接");
        Random random = new Random();
        int colorRandom = random.nextInt(10);
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os,true);
            pw.println(socket.getRemoteSocketAddress()+"欢迎链接");

            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while (!(line = br.readLine()).equals("exit")){
                System.out.println("\033[3"+colorRandom+"m"+"["+socket.getRemoteSocketAddress()+"]说:"+line+"\033[m");
            }
        } catch (IOException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
        }
    }
}

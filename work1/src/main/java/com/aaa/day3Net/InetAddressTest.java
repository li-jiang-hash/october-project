package com.aaa.day3Net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/*
 * @Author: 江Sir
 * @Date: 2022/10/10 15:09
 * @Description:
 * @Since version:  2022.10
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress baidu = InetAddress.getByName("baidu.com");
        System.out.println("baidu = " + baidu);
        InetAddress local = InetAddress.getLocalHost();
        System.out.println("local = " + local);
        InetAddress user = InetAddress.getByName("江Sir");
//        InetAddress user = InetAddress.getByName("192.168.31.25");
        System.out.println("user = " + user);
    }
}

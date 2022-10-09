package com.aaa;

import com.aaa.StudyThread.Safe;

public class SafeTest {
    public static void main(String[] args) {
        Safe safe = new Safe();
        Thread t1=new Thread(safe,"一");
        Thread t2=new Thread(safe,"二");
        Thread t3=new Thread(safe,"三");
        Thread t4=new Thread(safe,"四");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

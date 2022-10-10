package com.aaa;

import com.aaa.day1.StudyThread.Safe;

public class SafeTest {
    public static void main(String[] args) {
        Safe safe1 = new Safe(100);
        Thread t1=new Thread(safe1,"一");
        Thread t2=new Thread(safe1,"二");
        Thread t3=new Thread(safe1,"三");
        Thread t4=new Thread(safe1,"四");


//        Safe safe1 = new Safe();
//        Safe safe2 = new Safe();
//        Safe safe3 = new Safe();
//        Safe safe4 = new Safe();
//        Thread t1=new Thread(safe1,"一");
//        Thread t2=new Thread(safe2,"二");
//        Thread t3=new Thread(safe3,"三");
//        Thread t4=new Thread(safe4,"四");


        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}

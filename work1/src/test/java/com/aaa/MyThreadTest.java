package com.aaa;

import com.aaa.day1.StudyThread.MyRunnable;
import com.aaa.day1.StudyThread.MyThread;
import com.aaa.day1.StudyThread.SunCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThreadTest {

    public static void main(String[] args) {
        MyThread myThread = new MyThread("MyThread");
        MyThread t1 = new MyThread();

        //myThread.run();
        //开启多线程不能掉run()
        t1.start();
        myThread.start();



        MyRunnable myRunnable = new MyRunnable();
        //包装成Thread对象
        Thread t2 = new Thread(myThread);
        t2.setName("你好");
        t2.start();

        SunCallable callable = new SunCallable();
        FutureTask futureTask = new FutureTask<>(callable);
        Thread t3= new Thread(futureTask);
        t3.setName("callable");
        t3.start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
        }
        try {
            Object result = futureTask.get();
            System.out.println("result = " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}

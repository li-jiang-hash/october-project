package com.aaa.day1.StudyThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Safe implements Runnable {
    public Safe(int num) {
        this.num = num;
    }

    private int num;
    Lock lock = new ReentrantLock();
    boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            Safes();
//            try {
//                lock.lock();
//                if (num > 1) {
//                    System.out.println(Thread.currentThread().getName() + "卖出第" + --num + "张票");
//                } else break;
//            } finally {
//                lock.unlock();
//            }
        }
    }

    public synchronized void Safes() {
        //释放等待
        notifyAll();
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出第" + num-- + "张票");
        } else flag = false;
        //等待
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

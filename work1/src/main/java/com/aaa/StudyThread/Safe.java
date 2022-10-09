package com.aaa.StudyThread;

public class Safe implements Runnable {

    private int num = 100;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (num >1) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "卖出第" + --num + "张票");
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        throw new RuntimeException(e);
                    }
                } else break;
            }
        }
    }
}

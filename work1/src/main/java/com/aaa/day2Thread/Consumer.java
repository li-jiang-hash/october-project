package com.aaa.day2Thread;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/*
 * @Author: 江Sir
 * @Date: 2022/10/9 19:21
 * @Description:
 * @Since version:  2022.10
 */public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id :" + Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true) {
                PCData data = queue.take();
                if (data != null) {
                    int re = data.getData() * data.getData();
                    System.out.println("\033[94m"+MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re)+"\033[m");
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}

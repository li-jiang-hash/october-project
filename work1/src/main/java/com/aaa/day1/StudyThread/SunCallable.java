package com.aaa.day1.StudyThread;

import java.util.concurrent.Callable;

public class SunCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " = " + i);
            sum+=i;
            if(i==99){
                Thread.sleep(100);
            }
        }
        return sum;
    }
}

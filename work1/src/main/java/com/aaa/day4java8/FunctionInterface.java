package com.aaa.day4java8;

/*
 * @Author: 江Sir
 * @Date: 2022/10/11 15:29
 * @Description:
 * @Since version:  2022.10
 */
public interface FunctionInterface {
    void info(String info);

    default void show(){
        System.out.println("FunctionInterface.show");
    }
    static void play(){
        System.out.println("支付成功");
    }
}

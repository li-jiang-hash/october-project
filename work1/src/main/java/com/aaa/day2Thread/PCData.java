package com.aaa.day2Thread;

/*
 * @Author: 江Sir
 * @Date: 2022/10/9 19:23
 * @Description:
 * @Since version:  2022.10
 */
public class PCData {
    private final int intData;

    public PCData(int d) {
        intData = d;
    }

    public PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;

    }
}

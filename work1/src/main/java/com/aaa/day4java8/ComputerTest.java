package com.aaa.day4java8;

/*
 * @Author: 江Sir
 * @Date: 2022/10/11 17:01
 * @Description:
 * @Since version:  2022.10
 */
public class ComputerTest {
    public static int cal(int x,int y,ComputerInterface computerTest){
        return computerTest.calculate(x,y);
    }

    public static void main(String[] args) {
        ComputerTest computerTest =new ComputerTest();
        System.out.println(computerTest.cal(5, 8, ((num1, num2) -> num1 + num2)));
        System.out.println(computerTest.cal(5, 8, ((num1, num2) -> num1 - num2)));
        System.out.println(computerTest.cal(5, 8, ((num1, num2) -> num1 * num2)));
        System.out.println(computerTest.cal(50, 15, ((num1, num2) -> num1 / num2)));
    }
}

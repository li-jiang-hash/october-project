package com.aaa.day4java8;

import java.util.Date;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/*
 * @Author: 江Sir
 * @Date: 2022/10/11 15:30
 * @Description:
 * @Since version:  2022.10
 */
public class FunctionTest {
    public static Date testGetDate(Supplier<Date> supplier){
        return supplier.get();
    }
    public static void showDate(Consumer<String> consumer,String username){
        consumer.accept(username);
    }

    public static Boolean judgeSex(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }
    public static int testFunction(Function<String,Integer> function,String str){
        return function.apply(str);
    }
//    public static






    public static void main(String[] args) {
       ((FunctionInterface) info -> System.out.println("info = " + info)).info("你好");
       FunctionInterface.play();

        System.out.println("---------");
        System.out.println(FunctionTest.testGetDate(Date::new));
        System.out.println("---------------");
        FunctionTest.showDate(s -> System.out.println(s.toUpperCase()),"I like you");
        System.out.println("================");
        Person p1 = new Person("周",20,"女");
        Person p2 = new Person("周",18,"女");
        Person p3 = new Person("周",20,"男");
        System.out.println(FunctionTest.judgeSex(p1, p -> p.getSex().equals("女") && p.getAge() > 18));
        System.out.println(FunctionTest.judgeSex(p2, p -> p.getSex().equals("女") && p.getAge() > 18));
        System.out.println(FunctionTest.judgeSex(p3, p -> p.getSex().equals("女") && p.getAge() > 18));
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println(FunctionTest.testFunction(s -> s.length(),"lijiang"));
        Integer str = FunctionTest.testFunction(Integer::parseInt, "1221212");
        System.out.println("str = " + (str+1));
    }
}

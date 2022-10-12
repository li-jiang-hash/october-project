package com.aaa.day4java8;

import java.util.Comparator;
import java.util.TreeSet;

/*
 * @Author: 江Sir
 * @Date: 2022/10/11 16:08
 * @Description:
 * @Since version:  2022.10
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Person 李江 = new Person("李江", 20);
        Person p2 = new Person("jack", 22);
        Person p3 = new Person("Tom", 18);
        //简化版
//        TreeSet<Person> personSet = new TreeSet<>((a1,a2)->a1.getAge() - a2.getAge());
        //生成板
        TreeSet<Person> personSet = new TreeSet<>(Comparator.comparingInt(Person::getAge));
        personSet.add(李江);
        personSet.add(p2);
        personSet.add(p3);
        for(Person person:personSet) {
            System.out.println("person = " + person);
        }
    }
}

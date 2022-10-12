package com.aaa.day4java8;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @Author: 江Sir
 * @Date: 2022/10/12 16:43
 * @Description:
 * @Since version:  2022.10
 */
public class MethodReferencesTest {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        Person p1 = new Person("21的李江", 21, "男");
        Person p2 = new Person("22的李江", 22, "男");
        Person p3 = new Person("李江", 19, "男");
        Person p4 = new Person("20的李江", 20, "男");
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        /*Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/

        /*Collections.sort(list, (o1, o2) -> o1.getAge()-o2.getAge());*/
        Collections.sort(list, Comparator.comparingInt(Person::getAge));
        list.forEach(person -> System.out.println("person = " + person));
        System.out.println("--------------------");
        List<Integer> listArr = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8);
        /*Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a-b;
            }
        });*/

//        Collections.sort(list, (a, b) -> a-b);
//        Collections.sort(list,Integer::compare);
        listArr.forEach(System.out::println);


        System.out.println("--------------");
        Person person = new Person("jack", 21, "男");
        Supplier<String> supplier = () -> person.getName();
        System.out.println(supplier.get());
        System.out.println("%%%%%%%%%%%%%%%%%%");
        Supplier<String> supplier1 = person::toString;
        System.out.println(supplier1.get());

        System.out.println("-------------");
        /*Stream<Person> stream = list.stream();
        Stream<Person> salStream = stream.filter(p -> p.getAge()>18 );
        Stream<Person> personStream = salStream.filter(e->e.getName().length()>3);
        personStream.forEach(System.out::println);*/
        //整合上边三行
        Stream<Person> stream = list.stream();
        stream.filter(e->e.getAge()>18).filter(e->e.getName().length()>2).forEach(System.out::println);
        //统计
        long count = list.stream().filter(p->p.getAge()>18).sorted((o1,o2)->o2.getAge()-o1.getAge()).count();
        System.out.println("count = " + count);
        //聚合：计算所有人的年龄和
        Integer sumAge = list.stream().map(p->p.getAge()).collect(Collectors.toList()).stream().reduce(0,(a,b)->a+b);
        System.out.println("sumAge = " + sumAge);
    }
}

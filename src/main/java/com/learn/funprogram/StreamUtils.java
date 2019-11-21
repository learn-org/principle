package com.learn.funprogram;

import com.learn.entity.Dish;

import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author： lxj
 * @date： 2019/7/24
 * @description：
 */
public class StreamUtils {
    public static void main(String[] args) {
        List<Dish> menu=Dish.initList();
        List<String> threeHighCaloriesName=menu.stream().filter(d->{
            System.out.println("filtering："+d);
            return d.getCalories()>300;
        }).map(d->{
            System.out.println("maping："+d);
            return d.getName();
        }).limit(3).collect(Collectors.toList());
        System.out.println(threeHighCaloriesName);

        long count=menu.stream().filter(d->d.getCalories()>300).distinct().count();
        System.out.println("count："+count);

        List<Dish> skipList=menu.stream().filter(d->d.getCalories()>300).limit(3).skip(3).collect(Collectors.toList());
        System.out.println(skipList);

        menu.stream().forEach(System.out::println);
        System.out.println("##################################################################");
        List<Dish> sortList=menu.stream().sorted(Comparator.comparing(Dish::getCalories).reversed()).collect(Collectors.toList());
        System.out.println("sortList："+sortList);
        System.out.println("##################################################################");
        List<String> words= Arrays.asList("hello","word");
        List<String> wordList=words.stream().map(s->s.split("")).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println("wordList："+wordList);
        System.out.println("##################################################################");

        List<Integer> numbers=Arrays.asList(1,2,3,4);
        List<Integer> numberList= numbers.stream().map(n->n*n).collect(Collectors.toList());
        System.out.println("numberList："+numberList);
        System.out.println("##################################################################");
        List<Integer> numbers1=Arrays.asList(1,2,3);
        List<Integer> numbers2=Arrays.asList(4,5);
        List<int[]> intarrayList=numbers1.stream().flatMap(i->numbers2.stream().map(j->new int[]{i,j})).collect(Collectors.toList());
        System.out.println("intarrayList："+intarrayList);
        System.out.println("##################################################################");

        List<Integer> findNumbers=Arrays.asList(1,2,4,5,3);
        Optional<Integer> op=findNumbers.stream().findAny();
        Optional<Integer> op1=findNumbers.stream().findFirst();
        boolean b=findNumbers.stream().anyMatch(i->i==2);
        System.out.println("op.isPresent()："+op.isPresent());
        System.out.println("op："+op.get());
        System.out.println("op1："+op1.get());
        System.out.println("b："+b);
        System.out.println("##################################################################");
        List<Integer> countList=Arrays.asList(1,2,3,4);
        Optional sum=countList.stream().reduce((a,c)->a+c);
        Optional multi=countList.stream().reduce((a,c)->a*c);
        int multiSum=countList.stream().reduce(0,(a,c)->a*c);
        System.out.println("sum："+sum);
        System.out.println("multi："+multi);
        System.out.println("multiSum："+multiSum);
        System.out.println("##################################################################");
        int mapToIntSum=countList.stream().mapToInt(Integer::intValue).sum();
        OptionalInt mapToIntMax=countList.stream().mapToInt(Integer::intValue).max();
        System.out.println("mapToIntSum："+mapToIntSum);
        System.out.println("##################################################################");
        int[] array=IntStream.range(1,100).toArray();
        int[] arrayClosed=IntStream.rangeClosed(1,100).toArray();
        System.out.println("array："+Arrays.toString(array));
        System.out.println("arrayClosed："+Arrays.toString(arrayClosed));
    }
}

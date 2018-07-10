package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int soon = leftBorder;
            leftBorder = rightBorder;
            rightBorder = soon;
        }
        List<Integer> collection = IntStream.range(leftBorder, rightBorder + 1).boxed().collect(Collectors.toList());
        return collection.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (x, y) -> x + y);

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        if (leftBorder > rightBorder) {
            int soon = leftBorder;
            leftBorder = rightBorder;
            rightBorder = soon;
        }
        List<Integer> collection = IntStream.range(leftBorder, rightBorder + 1).boxed().collect(Collectors.toList());
        return collection.stream()
                .filter(x -> x % 2 == 1)
                .reduce(0, (x, y) -> x + y);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                        .reduce(0, (x, y) -> x + 3 * y + 2);
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                        .map(x -> (x % 2 != 0) ? 3 * x + 2 : x)
                        .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                        .filter(x -> x % 2 != 0)
                        .reduce(0, (x, y) -> x + y * 3 + 5);
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream()
                                            .filter(x -> x % 2 == 0)
                                            .sorted()
                                            .collect(Collectors.toList());
        return (collect.size() % 2 == 0) ? (collect.get((collect.size() - 1) / 2) + collect.get((collect.size()) / 2)) / 2 : collect.get((collect.size()) / 2);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                        .filter(x -> x % 2 == 0)
                        .mapToInt(Integer::intValue)
                        .average()
                        .getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return arrayList.stream()
                        .filter(x -> x % 2 == 0)
                        .collect(Collectors.toList())
                        .contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream()
                        .filter(x -> x % 2 == 0)
                        .distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> list = new ArrayList<>();
        List<Integer> evenNum = arrayList.stream()
                                        .filter(x -> x % 2 == 0)
                                        .sorted().collect(Collectors.toList());
        List<Integer> odd = arrayList.stream()
                                     .filter(x -> x % 2 != 0)
                                     .sorted((a, b) -> a > b ? -1 : 1)
                                     .collect(Collectors.toList());
        list.addAll(evenNum);
        list.addAll(odd);
        return list;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        AtomicInteger temp = new AtomicInteger(0);
        arrayList = arrayList.stream().map(x->{
            int result = (x+temp.get())*3;
            temp.set(x);
            return result;
        }).collect(Collectors.toList());
        arrayList.remove(0);
        return arrayList;


    }
}

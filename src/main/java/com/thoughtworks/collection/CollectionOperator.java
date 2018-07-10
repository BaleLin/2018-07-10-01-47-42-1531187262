package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList());
        } else {
            List<Integer> collect = IntStream.range(right, left + 1).boxed().collect(Collectors.toList());
            Collections.reverse(collect);
            return collect;
        }
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (right > left) {
            return IntStream.range(left, right + 1).boxed().collect(Collectors.toList()).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        } else {
            List<Integer> collect = IntStream.range(right, left + 1).boxed().collect(Collectors.toList()).stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
            Collections.reverse(collect);
            return collect;
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> list = buildListsFromArray(array);
        return list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = buildListsFromArray(firstArray);
        List<Integer> secondList = buildListsFromArray(secondArray);
        return firstList.stream().filter(secondList::contains).collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> list = new ArrayList<>();
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> collect = secondList.stream().filter(x -> !firstList.contains(x)).collect(Collectors.toList());
        list.addAll(firstList);
        list.addAll(collect);
        return list;
    }
}

package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream()
                        .reduce(0,(x, y) -> y>x?y:x);
    }

    public double getMinimum() {
        return arrayList.stream()
                        .reduce(99999999,(x, y) -> y<x?y:x);
    }

    public double getAverage() {
        return arrayList.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream().sorted().collect(Collectors.toList());
        return (collect.size() % 2 == 0) ? (collect.get((collect.size()) / 2 - 1) + collect.get((collect.size()) / 2)) * 1.0 / 2 : collect.get((collect.size()) / 2);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).get(0);
    }

    public int getIndexOfFirstEven() {
        AtomicInteger index = new AtomicInteger();
        AtomicBoolean first = new AtomicBoolean(true);
        arrayList.forEach(x -> {
            if (x % 2 == 0 && first.get()) {
                index.set(x);
                first.set(false);
            }
        });
        return arrayList.indexOf(index.get());
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (arrayList.size() != this.arrayList.size()) return false;
        for (int i = 0; i < arrayList.size(); i++) {
            if (!arrayList.get(i).equals(this.arrayList.get(i))) return false;
        }
        return true;
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (singleLink.getNode(i) != null) list.add((Integer)singleLink.getNode(i));
        }
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        return (collect.size() % 2 == 0) ? (collect.get((collect.size()) / 2 - 1) + collect.get((collect.size()) / 2)) * 1.0 / 2 : collect.get((collect.size()) / 2) * 1.0;
    }

    public int getLastOdd() {
        arrayList = arrayList.stream().filter(x -> x % 2 == 1).collect(Collectors.toList());
        return arrayList.get(arrayList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        AtomicInteger index = new AtomicInteger();
        arrayList.forEach(x -> {
            if (x % 2 == 1) {
                index.set(x);
            }
        });
        return arrayList.lastIndexOf(index.get());
    }
}

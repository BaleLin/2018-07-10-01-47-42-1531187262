package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        List<Integer> collect = IntStream.range(0, number - 1)
                                        .boxed()
                                        .collect(Collectors.toList());
        Collections.reverse(collect);
        return collect.stream().filter(x -> (number - x) % 2 == 0).collect(Collectors.toList());
    }
}

package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
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
        throw new NotImplementedException();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}

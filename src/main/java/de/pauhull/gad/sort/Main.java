package de.pauhull.gad.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        var algorithms = new SortingAlgorithm[]{
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort(),
        };

        int n = 100000;
        System.out.println("Testing sort algorithms with n=" + n);

        var random = new Random(0);
        var check = new ArrayList<Integer>();
        for(int i = 0; i < 100000; i++) {
            check.add(i);
        }
        Collections.shuffle(check, random);

        for(var algorithm : algorithms) {
            System.out.println("--- " + algorithm.name());
            var toSort = check.stream().mapToInt(Integer::intValue).toArray();
            var start = System.currentTimeMillis();
            algorithm.sort(toSort);
            var timeTakenMs = System.currentTimeMillis() - start;
            var nsPerItem = (timeTakenMs * 1000000) / toSort.length;
            var sorted = isSorted(toSort);
            System.out.println("Correctly sorted: " + sorted);
            System.out.println("Time per item: " + nsPerItem + "ns");
        }
    }

    private static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            if (arr[i+1] < arr[i]) {
                return false;
            }
        }
        return true;
    }
}

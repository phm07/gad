package de.pauhull.gad.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testAlgos(new SortingAlgorithm[]{
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort(),
                new RadixSort(),
        }, 10000);

        testAlgos(new SortingAlgorithm[]{
                new SelectionSort(),
                new InsertionSort(),
                new QuickSort(),
                new MergeSort(),
                new RadixSort(),
        }, 100000);

        testAlgos(new SortingAlgorithm[]{
                new QuickSort(),
                new MergeSort(),
                new RadixSort(),
        }, 10000000);
    }

    private static void testAlgos(SortingAlgorithm[] algorithms, int n) {
        System.out.println("Testing sorting algorithms with n=" + n);

        var random = new Random(0);
        var check = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
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
        System.out.println();
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

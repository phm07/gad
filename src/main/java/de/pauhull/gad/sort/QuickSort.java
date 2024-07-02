package de.pauhull.gad.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        quickSort(numbers, 0, numbers.length-1);
    }

    private void quickSort(int[] numbers, int l, int r) {
        if (r <= l) return;
        int p = numbers[r], i = l-1, j = r;
        while (i < j) {
            do {
                i++;
            } while (numbers[i] < p);
            do {
                j--;
            } while (j > l && numbers[j] > p);
            if(i < j) {
                swap(numbers, i, j);
            }
        }
        swap(numbers, i, r);
        quickSort(numbers, l, i-1);
        quickSort(numbers, i+1, r);
    }

    @Override
    public String name() {
        return "QuickSort";
    }
}

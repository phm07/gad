package de.pauhull.gad.sort;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        mergeSort(numbers, 0, numbers.length-1);
    }

    private void mergeSort(int[] numbers, int l, int r) {
        if (r <= l) {
            return;
        }
        int m = l+(r-l)/2;
        mergeSort(numbers, l, m);
        mergeSort(numbers, m+1, r);
        int[] helper = new int[r-l+1];
        int j = l, k = m+1;
        for(int i = 0; i < helper.length; i++) {
            if (k > r) {
                helper[i] = numbers[j++];
            } else if (j > m) {
                helper[i] = numbers[k++];
            } else if (numbers[j] < numbers[k]) {
                helper[i] = numbers[j++];
            } else {
                helper[i] = numbers[k++];
            }
        }
        System.arraycopy(helper, 0, numbers, l, helper.length);
    }

    @Override
    public String name() {
        return "MergeSort";
    }
}

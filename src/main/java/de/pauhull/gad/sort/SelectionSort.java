package de.pauhull.gad.sort;

public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            int min = i;
            for(int j = 1+i; j < numbers.length; j++) {
                if (numbers[j] < numbers[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(numbers, min, i);
            }
        }
    }

    @Override
    public String name() {
        return "SelectionSort";
    }
}

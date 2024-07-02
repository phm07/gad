package de.pauhull.gad.sort;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            for(int j = 0; j < numbers.length-i; j++) {
                if (numbers[j+1] < numbers[j]) {
                    swap(numbers, j, j+1);
                }
            }
        }
    }

    @Override
    public String name() {
        return "BubbleSort";
    }
}

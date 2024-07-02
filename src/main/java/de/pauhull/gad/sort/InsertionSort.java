package de.pauhull.gad.sort;

public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            for(int j = 0; j <= i; j++) {
                if (numbers[j] >= numbers[i]) {
                    int temp = numbers[i];
                    if (i != j) {
                        for(int k = i; k > j; k--) {
                            numbers[k] = numbers[k-1];
                        }
                        numbers[j] = temp;
                    }
                    break;
                }
            }
        }
    }

    @Override
    public String name() {
        return "InsertionSort";
    }
}

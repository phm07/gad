package de.pauhull.gad.sort;

public interface SortingAlgorithm {

    void sort(int[] numbers);

    String name();

    default void swap(int[] numbers, int a, int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }

}

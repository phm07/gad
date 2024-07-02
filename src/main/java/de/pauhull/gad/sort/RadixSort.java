package de.pauhull.gad.sort;

public class RadixSort implements SortingAlgorithm {
    @Override
    public void sort(int[] numbers) {
        int[] left = new int[numbers.length];
        int[] right = new int[numbers.length];
        int mask, j, k;
        for(int i = 0; i < 32; i++) {
            j = 0;
            k = 0;
            mask = 1 << i;
            for(int n : numbers) {
                if ((n&mask) == 0) {
                    left[j++] = n;
                } else {
                    right[k++] = n;
                }
            }
            System.arraycopy(left, 0, numbers, 0, j);
            System.arraycopy(right, 0, numbers, j, k);
        }
    }

    @Override
    public String name() {
        return "RadixSort";
    }
}

package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countingSort(new long[]{2, 3, 4, 8, 1, 5, 9, 7, 6
        })));
    }

    public static long[] countingSort(long[] a) {
        long[] b = new long[a.length];
        long k = a[0];
        for (final long x : a) {
            if (k < x) {
                k = x;
            }
        }
        long[] c = new long[(int) k + 1];
        for (int i = 0; i <= k; i++) {
            c[i] = 0;
        }

        for (int j = 0; j < a.length; j++) {
            c[(int) a[j]]++;
        }
        for (int i = 1; i <= k; i++) {
            c[i] += c[i - 1];
        }
        for (int j = a.length-1; j >= 0; j--) {
            b[(int) c[(int) a[j]]-1] = a[j];
            c[(int) a[j]]--;
        }
        return b;

    }
}
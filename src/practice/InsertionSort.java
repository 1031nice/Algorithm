package practice;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int [] array = {5, 3, 6, 4, 2, 1};
        sort(array, SortType.ASCEND);
        System.out.println(Arrays.toString(array));
        sort(array, SortType.DESCEND);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array, SortType type) {
        if(type == SortType.ASCEND) {
            ascendSort(array);
        }
        else {
            descendSort(array);
        }
        return array;
    }

    private static void descendSort(int[] array) {
        // find min and swap
        int indexOfMax = getIndexOfMax(array);
        swap(array, indexOfMax, 0);

        // insertion sort
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current > array[j]) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = current;
                    break;
                }
            }
        }
    }

    private static void ascendSort(int[] array) {
        // find min and swap
        int indexOfMin = getIndexOfMin(array);
        swap(array, indexOfMin, 0);

        // insertion sort
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    array[j + 1] = current;
                    break;
                }
            }
        }
    }

    private static int getIndexOfMax(int[] array) {
        int max = array[0];
        int indexOfMax = 0;
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    private static int getIndexOfMin(int[] array) {
        int min = array[0];
        int indexOfMin = 0;
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

enum SortType {
    ASCEND, DESCEND
}
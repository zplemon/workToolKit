package com.leetcode.microsoft.middle;

public class LM_00_DiffTwoArray {
    public static int[] diffTowArray(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return null;
        }

        if (array1 == null || array1.length == 0) {
            return array2;
        }

        if (array2 == null || array2.length == 0) {
            return array1;
        }

        int index1 = 0;
        int index2 = 0;

        int[] result = new int[array1.length + array2.length];
        int resultIndex = 0;


        while(index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                index1++;
                index2++;
            } else if (array1[index1] > array2[index2]) {
                result[resultIndex] = array2[index2];
                index2++;
                resultIndex++;
            } else if (array2[index2] > array1[index1]) {
                result[resultIndex] = array1[index1];
                index1++;
                resultIndex++;
            }
        }

        if (index1 < array1.length) {
            while(index1 < array1.length) {
                result[resultIndex] = array1[index1];
                resultIndex++;
                index1++;
            }
        }

        if (index2 < array2.length) {
            while(index2 < array2.length) {
                result[resultIndex] = array2[index2];
                resultIndex++;
                index2++;
            }
        }


        return result;
    }

    // [2,3,5],[1,3,6,7]
    public static void main(String[] args) {
        int[] array1 = new int[]{2,3,5,8};
        int[] array2 = new int[]{1,3,5,6,7};
        int[] result = diffTowArray(array1,array2);
        for(int i : result) {
            System.out.println("i = " + i);
        }
    }

}

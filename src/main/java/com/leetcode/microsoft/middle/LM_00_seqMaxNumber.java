package com.leetcode.microsoft.middle;

public class LM_00_seqMaxNumber {
    public static int calSeqMaxNumber(int[] input) {
        if (input == null) {
            return 0;
        }

        int sum = 0;
        int max = 0;

        //第一版是错的
//        for (int i = 0; i < input.length; i++) {
//            sum += input[i];
//            if (sum <= 0 && i != input.length - 1) {
//                sum = input[i + 1];
//            }
//
//            if (sum > max) {
//                max = sum;
//            }
//        }

        //这个是正确的
        for (int i : input) {
            //先判断，再加
            if (sum >= 0) {
                sum += i;
            } else {
                sum = i;
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-10,-1,2,3,-20,7};
        int result = calSeqMaxNumber(input);
        System.out.println("result = " + result);
    }

}

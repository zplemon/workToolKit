package com.leetcode.microsoft.swordpointingoffer;

/**
 * 旋转数组的最小数字；
 *
 * 有一个长度为 n 的非降序数组，比如[1,2,3,4,5]，将它进行旋转，
 * 即把一个数组最开始的若干个元素搬到数组的末尾，变成一个旋转数组，比如变成了[3,4,5,1,2]，或者[4,5,1,2,3]这样的。
 * 请问，给定这样一个旋转数组，求数组中的最小值。
 *
 * 要求：空间复杂度：O(1) ，时间复杂度：O(lgN)
 * /


/**
 * 参考链接：https://www.nowcoder.com/profile/470520/codeBookDetail?submissionId=60901457
 */
public class MinNumberInRotateArray {
    /*
     * 关键点1：比左边数大，比右边数小的数字
     */
    public static int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return array[i + 1];
            }
        }

        return array[0];
    }

    /*
     * 关键点2：二分法
     * 因为要求时间复杂度是O(lgN)，所以得用二分法
     */

    /**
     * 采用二分法解答这个问题，
     * mid = low + (high - low)/2
     * 需要考虑三种情况：
     * (1)array[mid] > array[high]:
     * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     * low = mid + 1
     * (2)array[mid] == array[high]:
     * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
     * 还是右边,这时只好一个一个试 ，
     * high = high - 1
     * (3)array[mid] < array[high]:
     * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     * 边。因为右边必然都是递增的。
     * high = mid
     * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
     * 比如 array = [4,6]
     * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
     * 如果high = mid - 1，就会产生错误， 因此high = mid
     * 但情形(1)中low = mid + 1就不会错误
     */
    public static int minNumberInRotateArray2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int low = 0, high = array.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            }
            // 这种情况得好好想想
            else if (array[mid] == array[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
         }

        return array[low];
    }

    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,1,2};
        System.out.println(minNumberInRotateArray(array));
        System.out.println(minNumberInRotateArray2(array));
    }
}

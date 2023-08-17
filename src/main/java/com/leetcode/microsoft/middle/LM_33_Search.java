package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/26 16:33
 */
public class LM_33_Search {

    /**
     * 搜索旋转排序数组
     */
    /**
     * 关键点：二分查找
     *
     */
    /**
     * 参考题解：https://leetcode.cn/problems/search-in-rotated-sorted-array/solutions/221435/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1 && nums[0] != target) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (nums[left] == target) {
                return left;
            }

            if (nums[right] == target) {
                return right;
            }

            if (nums[middle] == target) {
                return middle;
            }

            // 这里判断逻辑稍微复杂一些，先判断middle和left的大小，再继续判断
            if (nums[middle] >= nums[left]) {
                // int[] nums = new int[]{4,5,6,7,0,1,2};
                if (target > nums[left] && target < nums[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else {
                // int[] nums3 = new int[]{5,1,2,3,6};
                // int[] nums = new int[][8,9,2,3,6]
                if (target < nums[right]  && target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};

        System.out.println(search(nums, 5));

        int[] nums2 = new int[]{8,9,2,3,6};

        System.out.println(search(nums2, 9));

        int[] nums3 = new int[]{5,1,2,3,6};

        System.out.println(search(nums3, 1));
    }
}

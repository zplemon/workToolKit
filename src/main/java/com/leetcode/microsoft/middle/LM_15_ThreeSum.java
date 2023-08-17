package com.leetcode.microsoft.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/24 17:27
 */

public class LM_15_ThreeSum {
    /**
     * 参考：
     * https://leetcode.cn/problems/3sum/solutions/11525/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/
     *
     * （注释写的不错）
     * https://leetcode.cn/problems/3sum/solutions/11525/3sumpai-xu-shuang-zhi-zhen-yi-dong-by-jyd/comments/1136520
     */
    /**
     * 关键点： 排序+前后指针
     *
     * 网友发的：犹豫不决先排序，步步逼近双指针
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }

            //nums[k]值重复了，去重 （第一次写少了这个判断，不加这个会有重复数据）
            if(k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];

                if (sum == 0) {
                    List<Integer> treeSum = new ArrayList<>();
                    treeSum.add(nums[k]);
                    treeSum.add(nums[i]);
                    treeSum.add(nums[j]);
                    result.add(treeSum);

                    //（第一次写少了这个判断，不加这个会有重复数据）
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                } else if (sum < 0) {
                    //（第一次写少了这个判断，不加这个会有重复数据）
                    while (i < j && nums[i] == nums[++i]);
                } else {
                    //（第一次写少了这个判断，不加这个会有重复数据）
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        threeSum(nums);
        System.out.println("nums = " + nums);
    }
}

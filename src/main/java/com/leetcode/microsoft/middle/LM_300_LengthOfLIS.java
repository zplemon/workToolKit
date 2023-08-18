package com.leetcode.microsoft.middle;

import org.springframework.context.annotation.Description;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/17 16:38
 */
@Description("最长递增子序列")
public class LM_300_LengthOfLIS {

    /**
     * 第一次没想出来怎么做，感觉得用动态规划，实际确认得用动态规划
     * 参考：https://leetcode.cn/problems/longest-increasing-subsequence/solutions/24173/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
     *
     * 关键点: 动态规划
     *
     * 动态规划的步骤：
     * 1. 动态规划状态定义：
     *      dp[i] 的值代表 nums 以 nums[i]结尾的最长子序列长度
     * 2. 转移方程(根据第一步的状态定义实现)
     *      if(nums[j] < nums[i])
     *      dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
     */


    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        int[] dp = new int[nums.length];
        int result = 0;
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                result = Math.max(result, dp[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{0,1,0,3,2,3};
        System.out.println("lengthOfLIS(input) = " + lengthOfLIS(input));;
    }
}

package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 13:58
 */
public class LM_337 {
    /**
     * 二叉树相邻点不能同时收集，求可以收集的最大值
     * 关键点
     * 二叉树的动态规划
     * f(a，0)表示，不从a收集的最大值；f(a，1)表示从a收集的最大值
     * f(a，0)=max(f(a.left，0)，f(a.left，1))+max(f(a.right，0)，f(a.right，1))
     * f(a，1)=f(a.left，0)+f(a.right，1)+a.value
     */
}

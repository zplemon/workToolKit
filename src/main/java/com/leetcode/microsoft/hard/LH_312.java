package com.leetcode.microsoft.hard;


public class LH_312 {
    /**
     * 戳气球
     *
     * 关键点
     * 动态规划
     * 如果戳最后一个气球是k，那么f(0,k-1)和f(k+1,n)是相互独立的，所以f(i，j)=f(i，k-1)+f(k+1,j)+f(k，k)*(i-1)*(j+1)
     * 具体看bilibili上的视频
     */
}

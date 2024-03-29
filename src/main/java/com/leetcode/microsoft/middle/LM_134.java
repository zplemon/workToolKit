package com.leetcode.microsoft.middle;
public class LM_134 {

    /**
     * 134题-加油站
     * 寻找可以绕一圈的路线
     * 关键点
     * 暴力方法-两个for循环，依次判断能不能绕一圈
     * 优化方法-当从0开始的走的时候，如果到3没油了，不能绕一圈，这个时候不用从1开始判断了，而是从3开始继续判断，这样时间复杂度是o(n)
     * 因为0到1是可以的，但是0到3是没油了，那么从1到3肯定也是不够的。所以不用从1，2开始判断了，直接从3开始继续判断
     */

}

package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 14:04
 */
public class LM_419 {
    /**
     * 甲板上的战舰个数
     *
     * 甲板上的战舰是按照一定要求排列的，只能按照横向或者竖向排列，而且战舰之间有间隔
     * 跟经典的小岛问题是同样的解法-都是使用DFS算法
     * 关键点总结
     * 方法一-DFS深度优先遍历算法
     * 两个for循环遍历二维数组，判断是不是战舰，如果是的话，使用DFS算法把战舰都进行沉没，这样下次遍历的时候就不会再+1了
     * 方法二-利用战舰的布局特点，当遍历位置的左边或者上边不为战舰时，才进行+1操作
     * 关键还是找到战舰布局的特点，找到规律就好了
     */
}
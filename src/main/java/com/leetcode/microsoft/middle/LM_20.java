package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 13:41
 */
public class LM_20 {
    /**
     * 有效括号问题
     */
    /**
     * 关键点：
     * 用栈来实现
     * 方法一
     * 用hashmap保存三种括号的配对情况。key是左括号，value是对应的右括号
     * 判断字符串在hashmap的话将对应的右括号放入stack中。
     * 不在hashmap的话将stack pop一个元素，跟当前字符串比较，不一样的话，返回false
     * 最后判断stack是否为空，不为空返回false，为空返回true
     * 方法二
     * 不借助hashmap
     * 当字符串是左括号时，把左括号都放入stack中
     * 当字符串是右括号时，将stack pop出来，判断跟当前字符串是否匹配
     */


}

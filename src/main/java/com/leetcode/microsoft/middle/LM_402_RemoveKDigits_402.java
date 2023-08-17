package com.leetcode.microsoft.middle;

import java.util.Stack;

/**
 * 402题
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 */

/**
 * 关键点-从左到右，找第一个比后面大的字符，删除，清零，k次扫描。
 */

/**
 * 一些不错的题解：
 * https://leetcode.cn/problems/remove-k-digits/solutions/482445/dong-tu-shuo-suan-fa-zhi-yi-diao-kwei-shu-zi-by-yu/
 * https://leetcode.cn/problems/remove-k-digits/solutions/2253613/yong-dan-diao-zhan-jie-jue-yi-diao-kwei-s56ff/
 */
public class LM_402_RemoveKDigits_402 {
    static public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        StringBuilder s = new StringBuilder(num);

        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j - 1) > s.charAt(j)) {
                    idx = j - 1;
                    break;
                } else {
                    idx = j;
                }
            }

            s.delete(idx, idx + 1);

            while (s.length() > 1 && s.charAt(0) == '0') {
                s.delete(0, 1);
            }
        }

        if(s.length() == 0) {
            return "0";
        }

        return s.toString();
    }

    /**
     * 题解-https://leetcode.cn/problems/remove-k-digits/solutions/2253613/yong-dan-diao-zhan-jie-jue-yi-diao-kwei-s56ff/
     */
    static public String removeKdigits2(String num, int k) {
        int n = num.length();//n:字符串长度
        if (n == k) return "0";

        Stack<Character> resStack = new Stack<>();
        int count = 0;//删除元素的个数

        for (int i=0;i<n;i++) {
            //如果栈不为空 并且 栈顶元素>当前遍历到的元素 并且 删除元素的个数未达到k，栈顶元素出栈
            while(!resStack.isEmpty() && resStack.peek()>num.charAt(i) && count<k){
                resStack.pop();
                count++;
            }

            if(resStack.isEmpty() && num.charAt(i) == '0'){
                continue;
            }
            else{
                resStack.push(num.charAt(i));
            }

        }

        //如果遍历完了整个字符串，已删除的元素个数仍未达到k
        while(!resStack.isEmpty() &&count<k ){
            resStack.pop();
            count++;
        }

        if (resStack.isEmpty()) return "0";

        StringBuffer sb = new StringBuffer();

        while(!resStack.isEmpty()){
            sb.insert(0,resStack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219", 3));

        System.out.println(removeKdigits2("1432219", 3));
    }

}

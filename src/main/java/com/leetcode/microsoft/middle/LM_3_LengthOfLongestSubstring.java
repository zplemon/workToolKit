package com.leetcode.microsoft.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/19 18:26
 */
/**
 * 关键点：计数器+滑动窗口
 */

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/discussion/comments/1675562
 */

/**
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/227999/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetc-2/
 */

public class LM_3_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
            max = Math.max(max, set.size());
        }

        return max;
    }
}

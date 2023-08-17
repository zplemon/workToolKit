package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 13:38
 */
public class LM_19 {

    /**
     * 删除链表倒数第n个节点
     */

    /**
     * 关键点：
     * 使用双指针
     * 快指针多走一步，走n+1步，这样是让慢指针指向倒数第n+1个节点，可以很方便的删除第n个节点
     * 边界考虑，当链表只有1个节点，要删除倒数第1个节点时，得用一个临时节点来指向第一个节点，快慢指针刚开始都是指向临时节点，这样方便处理这种边界情况
     */


}

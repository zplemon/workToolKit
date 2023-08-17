package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 13:43
 */
public class LM_24 {

    /**
     * 两两交换链表中的节点
     */

    /**
     * 关键点
     * 在交换两个节点n1和n2之前，还得有一个指针current
     * n1=current.next
     * n2=current.next.next
     * 在链表的第一个元素之前，应该再创建一个临时节点dumy，方便交换第一和第二个节点
     * 一共六步（记住这些步骤）
     * n1=current.next
     * n2=current.next.next
     * current.next=n2
     * n1.next=n2.next
     * n2.next=n1
     * current=n1
     */
}

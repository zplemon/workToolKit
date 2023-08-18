package com.leetcode.microsoft.middle;

import org.springframework.context.annotation.Description;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/18 16:06
 */
@Description("环形链表2")
public class LM_142_DetectCycle {

    /**
     * 关键点: 快慢指针
     * 以前常见的题目
     */
    /**
     * 参考题解：https://leetcode.cn/problems/linked-list-cycle-ii/solutions/12616/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;


        while(true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }


   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}

package com.leetcode.microsoft.middle;

import org.springframework.context.annotation.Description;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/15 10:09
 */
@Description("反转链表二-从第m,n之间反转链表")
public class LM_92_ReverseBetween {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  /**
   * 参考（写的很不错）：
   * Java-双指针-头插法
   * https://leetcode.cn/problems/reverse-linked-list-ii/solutions/138910/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
   *
   * 关键点：
   * 1. 头插法(查看上面的图解)
   * 2. 虚拟头节点是真的好用, 凡是需要考虑左右边界的问题, 加个虚拟头节点准没错.
   *
   */
    public ListNode reverseBetween(ListNode head, int left, int right) {
      if (left == right) {
        return head;
      }

      ListNode root = new ListNode(0);
      root.next = head;

      ListNode pre = root;
      ListNode cur = head;


      for (int i = 0; i < left - 1; i++) {
        pre = pre.next;
        cur = cur.next;
      }

      for (int j = 0; j < right - left; j++) {
        ListNode nextNode = cur.next;
        cur.next = cur.next.next;
        nextNode.next = pre.next;
        //nextNode.next = cur;(写成这样会报错，要写成pre.next,这点要注意一下)
        pre.next = nextNode;
      }

      return root.next;

    }


}

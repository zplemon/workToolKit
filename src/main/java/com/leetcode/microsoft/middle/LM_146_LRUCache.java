package com.leetcode.microsoft.middle;

import java.util.HashMap;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/20 14:56
 */

/**
 * 关键点：HashMap+双向链表
 * HashMap用来快速查找数据
 * 双向链表用来实现LRU淘汰策略
 */

/**
 * LRU算法
 * 关键点
 * HashMap+双向链表
 * HashMap用来保存链表上所有节点的位置，方便进行查找
 * 双向链表是用来进行数据的插入和删除，每次访问以后，要将该节点放到head后面(head.next=最热节点)，如果是新插入的节点，也是放在head后面，如果链表长度超过最大容量，将最后一个节点删除(热度最低的节点)
 * head和tail是辅助节点，不保存数据，刚开始head.next=tail，tail.pre=head
 */

/**
 * 参考
 * https://leetcode.cn/problems/lru-cache/solution/146-lru-huan-cun-ji-zhi-ha-xi-biao-shuan-l3um/
 */
public class LM_146_LRUCache {
    private int capacity;
    private HashMap<Integer, ListNode> hashMap;
    private ListNode head;
    private ListNode tail;


    public class ListNode {
        private int key;
        private int val;
        private ListNode pre;
        private ListNode next;
        public ListNode() {

        }

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }


    }

    public LM_146_LRUCache(int capacity) {
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
        this.head = new ListNode();
        this.tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }

    private void removeNode(ListNode node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        }
    }

    private void addNodeToHead(ListNode node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private void moveNodeToHead(ListNode node) {
        removeNode(node);
        addNodeToHead(node);
    }

    public int get(int key) {
        ListNode valueNode = hashMap.get(key);
        if (valueNode != null) {
            moveNodeToHead(valueNode);
            return valueNode.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            ListNode node = hashMap.get(key);
            node.val = value;
            moveNodeToHead(node);
            return;
        }
        if (hashMap.size() >= capacity) {
            hashMap.remove(tail.pre.key);
            removeNode(tail.pre);
        }
        ListNode node = new ListNode(key, value);
        hashMap.put(key, node);
        moveNodeToHead(node);
    }
}

package com.leetcode.microsoft.middle;

/**
 * 解题思路
 * 以当前节点node为视角，它的左孩子与右孩子，多了的传给我，少了的就传负的给我，这个过程可记录move的累计值
 * 至于 node，再结合此时自己的 val，回溯成上一层的孩子
 */
/*
 * 链接：
 * https://leetcode.cn/problems/distribute-coins-in-binary-tree/solutions/2343542/shen-du-you-xian-sou-suo-si-lu-by-jiu-we-cy48/
 */
public class LM_979_DistributeCoins {

    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      };


    static int move = 0;

    public static int distributeCoins(TreeNode root) {
        needCoins(root);

        return move;
    }

    private static int needCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = needCoins(root.left);
        int right = needCoins(root.right);


        move += Math.abs(left) + Math.abs(right);

        int cur = root.val - 1;

        int needCoins = cur + left + right;

        System.out.println("cur = " + cur + ", left = " + left + ", right = " + right + ", needCoins = " + needCoins + ", move = " + move);


        return needCoins;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(0);
        root.left = left;
        root.right = right;

        System.out.println("distributeCoins(root) = " + distributeCoins(root));
    }

}

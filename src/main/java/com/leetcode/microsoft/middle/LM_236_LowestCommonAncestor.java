package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/2 15:08
 */
public class LM_236_LowestCommonAncestor {

    /**
     * 参考：
     * https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/solutions/240096/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-hou-xu/
     * 还没有写出来，这个解析还不错，可以多看看
     * 刷题的时候两个同事都看到了，真的烦
     */


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        /**
         * 1. 所有 Node.val 互不相同 。
         * 2. p != q
         * 3. p 和 q 均存在于给定的二叉树中
         * 所以当root等于p,q，则直接返回 root；
         */
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }




    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          this.val = x;
      }
   }
}

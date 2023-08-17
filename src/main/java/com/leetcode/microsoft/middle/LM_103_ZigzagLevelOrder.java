package com.leetcode.microsoft.middle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/1 15:05
 */
public class LM_103_ZigzagLevelOrder {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        stack1.add(root);

        while (!stack1.isEmpty()) {
            List<Integer> levelResult1 = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode node = stack1.pop();
                levelResult1.add(node.val);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }

            result.add(levelResult1);

            if (!stack2.isEmpty()) {
                List<Integer> levelResult2 = new ArrayList<>();
                while (!stack2.isEmpty()) {
                    TreeNode node = stack2.pop();
                    levelResult2.add(node.val);
                    if (node.right != null) {
                        stack1.push(node.right);
                    }
                    if (node.left != null) {
                        stack1.push(node.left);
                    }
                }
                result.add(levelResult2);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //root = [3,9,20,null,null,15,7]
        TreeNode rootLeft = new TreeNode(9);

        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        TreeNode rootRight = new TreeNode(20, rightLeft, rightRight);

        TreeNode root = new TreeNode(3, rootLeft, rootRight);

        List<List<Integer>> result = zigzagLevelOrder(root);


        for (int i = 0; i < result.size(); i++) {
            System.out.println("result = " + result.get(i));
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println("result22 = " + result.get(i).get(j));
            }
        }
    }



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
    }
}

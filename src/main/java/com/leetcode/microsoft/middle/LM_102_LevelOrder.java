package com.leetcode.microsoft.middle;

import com.workToolKit.tool.GsonUtil;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/25 16:05
 */
public class LM_102_LevelOrder {


    /**
     * 自己写出来的，没有看题解，有空可以再看看其他人的写法
     */
    /**
     * 关键点：双队列，用来标识不同层次
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue1 = new ArrayDeque<>();
            Queue<TreeNode> queue2 = new ArrayDeque<>();

            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            queue1.add(root);

            while (!queue1.isEmpty()) {
                List<Integer> levelResult1 = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode peekNode = queue1.poll();
                    levelResult1.add(peekNode.val);

                    if (peekNode.left != null) {
                        queue2.add(peekNode.left);
                    }

                    if (peekNode.right != null) {
                        queue2.add(peekNode.right);
                    }
                }
                result.add(levelResult1);


                if (!queue2.isEmpty()) {
                    List<Integer> levelResult2 = new ArrayList<>();
                    while (!queue2.isEmpty()) {
                        TreeNode peekNode = queue2.poll();
                        levelResult2.add(peekNode.val);
                        if (peekNode.left != null) {
                            queue1.add(peekNode.left);
                        }

                        if (peekNode.right != null) {
                            queue1.add(peekNode.right);
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

        List<List<Integer>> result = levelOrder(root);


        for (int i = 0; i < result.size(); i++) {
            System.out.println("result = " + result.get(i));
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.println("result22 = " + result.get(i).get(j));
            }
        }

        System.out.println("result = " + result);

        System.out.println("result toString = " + GsonUtil.toJson(result));



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



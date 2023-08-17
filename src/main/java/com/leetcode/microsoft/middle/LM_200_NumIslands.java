package com.leetcode.microsoft.middle;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/7/27 13:56
 */
public class LM_200_NumIslands {

    /**
     * 岛屿数量
     *
     * DFS(递归实现)+沉没(把当前数字从1变成0)
     */
    /**
     * 关键点总结
     * 方法一-DFS深度优先遍历算法
     *      两个for循环遍历二维数组，判断是不是战舰，如果是的话，使用DFS算法把岛屿都进行沉没，这样下次遍历的时候就不会再+1了
     * 方法二-利用岛屿布局特点，当遍历位置的左边或者上边不为岛屿时，才进行+1操作
     *      关键还是找到岛屿布局的特点，找到规律就好了
     */


    /**
     * 参考：https://leetcode.cn/problems/number-of-islands/solutions/1509908/dai-ma-jian-ji-yi-chong-huan-bu-cuo-de-j-6bvq/
     *
     * 一共有3种方法（DFS，BFS，,并查集）
     *  这里只写了DFS，有空可以研究一下
     */
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int numIsLands = 0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    numIsLands++;
                    dfs(grid, r , c);
                }
            }
        }

        return  numIsLands;
    }

    static void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        System.out.println("numIsLands : " + numIslands(grid));
    }
}

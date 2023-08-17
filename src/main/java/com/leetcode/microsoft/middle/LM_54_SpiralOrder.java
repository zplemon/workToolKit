package com.leetcode.microsoft.middle;

import org.springframework.context.annotation.Description;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author Zhangpeng8
 * @Team: ofa-st
 * @Create 2023/8/14 11:01
 */
@Description("循环打印二维数组")
public class LM_54_SpiralOrder {
    /**
     * 自己写出来的，有空也可以看看题解
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        int loop = 0;

        int right = n - loop;
        int bottom = m - loop;
        int left = loop;
        int top = loop;

        System.out.println("init, right = " + right + ", bottom = " + bottom + ", left = " + left + ", top = " + top);


        while(left < right && top < bottom) {


            for (int i = loop; i < right; i++) {
                System.out.println(matrix[top][i]);
                result.add(matrix[top][i]);
            }

            for (int j = loop + 1; j < bottom; j++) {
                System.out.println(matrix[j][right - 1]);
                result.add(matrix[j][right - 1]);
            }

            if (loop + 1 >= bottom) {
                break;
            }

            for (int k = right - 2; k >= left; k--) {
                System.out.println(matrix[bottom - 1][k]);
                result.add(matrix[bottom - 1][k]);
            }

            if (right - 2 < left) {
                break;
            }

            for (int l = bottom - 2; l >= top + 1; l--) {
                System.out.println(matrix[l][loop]);
                result.add(matrix[l][loop]);
            }

            loop++;

            right = n - loop;
            bottom = m - loop;
            left = loop;
            top = loop;

            System.out.println("right = " + right + ", bottom = " + bottom + ", left = " + left + ", top = " + top);
        }

        return result;

    }


    public static List<Integer> spiralOrderV2(int[][] matrix) {
        if (matrix == null) {
            return null;
        }

        List<Integer> result = new ArrayList<>();


        int m = matrix.length;
        int n = matrix[0].length;

        int[][] visit = new int[m][n];

        int loop = 0;

        int right = n - loop;
        int bottom = m - loop;
        int left = loop;
        int top = loop;

        System.out.println("init, right = " + right + ", bottom = " + bottom + ", left = " + left + ", top = " + top);


        while(left < right && top < bottom) {


            for (int i = loop; i < right; i++) {
                System.out.println(matrix[top][i]);
                if (visit[top][i] == 1) {
                    continue;
                }
                result.add(matrix[top][i]);
                visit[top][i] = 1;
            }

            for (int j = loop + 1; j < bottom; j++) {
                if (visit[j][right - 1] == 1) {
                    continue;
                }
                System.out.println(matrix[j][right - 1]);
                result.add(matrix[j][right - 1]);
                visit[j][right - 1] = 1;
            }


            for (int k = right - 2; k >= left; k--) {
                if (visit[bottom - 1][k] == 1) {
                    continue;
                }
                System.out.println(matrix[bottom - 1][k]);
                result.add(matrix[bottom - 1][k]);
                visit[bottom - 1][k] = 1;
            }


            for (int l = bottom - 2; l >= top + 1; l--) {
                if (visit[l][loop] == 1) {
                    continue;
                }
                System.out.println(matrix[l][loop]);
                result.add(matrix[l][loop]);
                visit[l][loop] = 1;
            }

            loop++;

            right = n - loop;
            bottom = m - loop;
            left = loop;
            top = loop;

            System.out.println("right = " + right + ", bottom = " + bottom + ", left = " + left + ", top = " + top);
        }

        return result;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        spiralOrder(matrix);

        int[][] matrix2 = new int[][] {{1,2,3,4,5},{16, 17, 18, 19, 6},{15, 24, 25, 20, 7}, {14, 23, 22, 21, 8}, {13, 12, 11, 10, 9}};

        spiralOrder(matrix2);
    }
}

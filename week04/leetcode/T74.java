package week04.leetcode;

/**
 * 74. 搜索二维矩阵
 * 地址:https://leetcode-cn.com/problems/search-a-2d-matrix/
 * 说明:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 */
public class T74 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;

        boolean b = searchMatrix(matrix, target);
        System.out.println(b);
    }

    /**
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * 解题思路:
     * 根据行的最后一列定位行  在持续缩减列下标查找元素
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int rows = 0;
        int col = matrix[0].length - 1;
        while (rows >= 0 && rows < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[rows][col] == target) {
                return true;
            } else if (matrix[rows][col] > target) {
                col--;
            } else {
                rows++;
            }
        }
        return false;
    }
}

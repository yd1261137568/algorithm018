package week04.leetcode;

/**
 * 题目:200. 岛屿数量
 * 地址:https://leetcode-cn.com/problems/number-of-islands/
 * 说明:
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class T200 {
    public static void main(String[] args) {
        char[][] numIslands = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}};
        int i = numIslands(numIslands);
        System.out.println(i);
    }


    /**
     *
     *  广度优先遍历
     * 时间复杂度:O(MN)
     * 空间复杂度:O(MN)
     * 解题思路:
     * 遍历二维数组,找到为1的节点,并将其相邻为1节点全部置为0 此时岛屿数据加一,直到遍历完数据得出岛屿数量
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }

        return num;
    }


    private static void dfs(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length | j < 0 || j >= grid[0].length  || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}

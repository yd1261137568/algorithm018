package week08.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:51. N 皇后
 * 地址:https://leetcode-cn.com/problems/n-queens/
 * 说明:n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class T51 {
    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);

        for (List<String> list : lists) {
            System.out.println(list);
        }

    }

    static List<List<String>> res = new ArrayList<>();

    /**
     * 回溯 + 剪枝
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] chars = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = '.';
            }
        }

        solve(chars, 0);

        return res;
    }

    private static void solve(char[][] chars, int row) {
        //递归终止条件
        if (row == chars.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                list.add(new String(chars[i]));
            }
            res.add(list);
        }

        //逐行尝试每一列
        for (int col = 0; col < chars.length; col++) {
            if (valid(chars, row, col)) {
                //满足条件置为Q
                chars[row][col] = 'Q';
                //继续递归下一层
                solve(chars, row + 1);
                //重置状态
                chars[row][col] = '.';
            }
        }
    }

    //判断当前位置能否放置皇后
    public static boolean valid(char[][] chars, int row, int col) {
        //由于是逐行放置 所以只需要判断上层是否冲突就行
        for (int i = 0; i < row; i++) {
            if (chars[i][col] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的右上角有没有皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < chars.length; i--, j++) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        //判断当前坐标的左上角有没有皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chars[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }


}

package week03.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:77. 组合
 * 地址:https://leetcode-cn.com/problems/combinations/
 * 说明:给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class T77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(3, 2);

        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }

    }

    //定义存储结构
    static List<List<Integer>> res = new ArrayList<List<Integer>>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(n, 0, new ArrayList<>(), k);
        return res;
    }

    /*
     *回溯获取集合
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static void dfs(int n, int depth, ArrayList<Integer> integers, int k) {
        if (integers.size() == k) {
            res.add(new ArrayList<>(integers));
            return;
        }

        for (int i = depth; i < n - (k - integers.size()) + 1; i++) {
            integers.add(i + 1);
            dfs(n, ++depth, integers, k);
            integers.remove(integers.size() - 1);
        }
    }
}

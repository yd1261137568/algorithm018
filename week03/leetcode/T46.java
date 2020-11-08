package week03.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目:46. 全排列
 * 地址:https://leetcode-cn.com/problems/permutations/
 * 说明:给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class T46 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        for (List<Integer> integers : permute(arr)) {
            System.out.println(integers);
        }

    }

    //定义全局结果数据结构
    static List<List<Integer>> res = new ArrayList<>();

    /**
     * dfs 递归排列
     * 时间复杂度: O(n*n!)
     * 空间复杂度: O(n)
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {

        //use数组控制状态 代表每个分支中的数字是否已被使用
        boolean[] use = new boolean[nums.length];

        dfs(nums, new ArrayList<Integer>(), use);
        return res;
    }

    private static void dfs(int[] nums, ArrayList<Integer> integers, boolean[] use) {
        //integers 临时结构 限定单个分支上一个完整的组合 用integers的size控制递归层级(剩余空间)
        if (integers.size() == nums.length) {
            //引用类型址传递 构造新集合 防止影响后续结果
            res.add(new ArrayList<>(integers));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //数据已被使用 跳过当前循环
            if (use[i]) {
                continue;
            }
            integers.add(nums[i]);
            use[i] = true;
            dfs(nums, integers, use);
            //回溯 消除状态
            use[i] = false;
            integers.remove(integers.size() - 1);
        }
    }


}

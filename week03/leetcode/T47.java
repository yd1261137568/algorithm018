package week03.leetcode;

import java.util.*;

/**
 * 题目:47. 全排列 II
 * 地址:https://leetcode-cn.com/problems/permutations-ii/
 * 说明:给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */
public class T47 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 3};
        for (List<Integer> integers : permuteUnique(arr)) {
            System.out.println(integers);
        }
    }


    //定义全局结果数据结构
    static List<List<Integer>> res = new ArrayList<>();


    /**
     * 在46的基础上进行排序 找出剪枝条件  use[i] || (i>0 && nums[i]=nums[i-1] && !use[i-1])
     * 时间复杂度: O(n*n!)
     * 空间复杂度: O(n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {

        boolean[] use = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), use);
        return res;
    }

    private static void dfs(int[] nums, ArrayList<Integer> integers, boolean[] use) {
        if (integers.size() == nums.length) {
            res.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (use[i] || (i>0 && nums[i]==nums[i-1] && !use[i-1])) {
                continue;
            }
            integers.add(nums[i]);
            use[i] = true;
            dfs(nums, integers, use);
            use[i] = false;
            integers.remove(integers.size() - 1);
        }

    }


}

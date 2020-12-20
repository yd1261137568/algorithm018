package week09.leetcode;

/**
 * 题目:300. 最长递增子序列
 * 地址:https://leetcode-cn.com/problems/longest-increasing-subsequence/
 * 说明:给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class T300 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(arr));
    }


    /**
     * dp + 二分
     * 时间复杂度:O(nlongn)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        int[] arr = new int[nums.length];
        int res = 0;

        for (int num : nums) {
            int i = 0;
            int j = res;
            //二分遍历 降低检索次数
            while (i < j) {
                int m = (i + j) / 2;
                if (arr[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            arr[i] = num;
            if (res == j) {
                res++;
            }
        }
        return res;
    }
}

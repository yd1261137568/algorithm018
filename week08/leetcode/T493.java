package week08.leetcode;

/**
 * 题目:493. 翻转对
 * 地址:https://leetcode-cn.com/problems/reverse-pairs/
 * 说明:给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 */
public class T493 {
    public static void main(String[] args) {
        reversePairs(new int[]{1, 3, 2, 3, 1});
    }


    /**
     * 归并排序 降低时间复杂度
     * 时间复杂度:O(nlogn)
     * 空间复杂度:O(n)
     * @param nums
     * @return
     */
    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }

        int mid = (left + right) >> 1;

        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);

        // 中间数组用于合并
        int[] cache = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0, tmp = left;

        while (j <= right) {
            while (tmp <= mid && nums[tmp] <= 2 * (long) nums[j]) {
                tmp++;
            }
            while (i <= mid && nums[i] < nums[j]) {
                cache[k++] = nums[i++];
            }
            cache[k++] = nums[j++];
            count += mid - tmp + 1;
        }

        while (i <= mid) {
            cache[k++] = nums[i++];
        }
        System.arraycopy(cache, 0, nums, left, right - left + 1);
        return count;
    }

}

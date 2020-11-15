package week04.leetcode;

/**
 * 153. 寻找旋转排序数组中的最小值
 * 地址:https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 说明:
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。
 * 请找出其中最小的元素。
 */
public class T153 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int min = findMin(nums);
        System.out.println(min);
    }

    /**
     * 时间复杂度:O(logn)
     * 空间复杂度:O(1)
     * 解题思路:
     * 根据中间点与右顶点的关系判断是向左还是向右遍历
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];

    }
}

package week04.leetcode;

/**
 * 55. 跳跃游戏
 * 地址:https://leetcode-cn.com/problems/jump-game/
 * 说明:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 */
public class T55 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 0, 0};
        System.out.println(canJump(nums));
    }

    /**
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * 解题思路:
     * 贪心 找每次可能调到的最远距离
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

        int rightmost = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;


    }
}

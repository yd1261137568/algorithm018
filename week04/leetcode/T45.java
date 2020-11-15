package week04.leetcode;

/**
 * 45. 跳跃游戏 II
 * 地址:https://leetcode-cn.com/problems/jump-game-ii/
 * 说明:
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 */
public class T45 {
    public static void main(String[] args) {
        int jump = jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(jump);
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 解释思路:
     * 贪心 找出每次能走的点中唯一最远的点,也是次数少到达最后一个位置的方案
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        int rightmost = 0;
        int end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            rightmost = Math.max(rightmost, i + nums[i]);
            if (end == i) {
                end = rightmost;
                step++;
            }
        }
        return step;
    }
}

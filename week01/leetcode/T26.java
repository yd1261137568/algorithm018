package week01.leetcode;

/**
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */

public class T26 {
    public static void main(String[] args) {
        int[] ints = {1, 1, 2};
        int i = removeDuplicates(ints);
        System.out.println("length:" + i);

        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return ++index;
    }
}

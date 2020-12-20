package week09.leetcode;

/**
 * 题目:917. 仅仅反转字母
 * 地址:https://leetcode-cn.com/problems/reverse-only-letters/
 * 说明:给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
 */
public class T917 {
    public static void main(String[] args) {
        String str = "7_28]";
        System.out.println(reverseOnlyLetters(str));
    }


    /**
     * 双指针交换  是字符 交换left right  不是字符left++  right-- 直到满足left>=right 停止
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     * @param S
     * @return
     */
    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {

            //left 不是字母 且 left < right
            while (!((chars[left] >= 'a' && chars[left] <= 'z') || (chars[left] >= 'A' && chars[left] <= 'Z')) && left < right) {
                left++;
            }

            //right 不是字母 且 left < right
            while (!((chars[right] >= 'a' && chars[right] <= 'z') || (chars[right] >= 'A' && chars[right] <= 'Z')) && left < right) {
                right--;
            }

            //交换位置
            if (left < right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        return new String(chars);
    }
}

package week09.leetcode;

/**
 * 题目:680. 验证回文字符串 Ⅱ
 * 地址:https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 说明:给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 */
public class T680 {
    public static void main(String[] args) {
        String str1 = "7_28]";
        System.out.println(validPalindrome(str1));
    }


    /**
     * 二分遍历 + 分治?
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param s
     * @return
     */
    public static boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            char c1 = s.charAt(left);
            char c2 = s.charAt(right);

            if (c1 == c2) {   //相同
                left++;
                right--;
            } else {         //不同
                boolean flag1 = true;
                boolean flag2 = true;
                char c3;
                char c4;

                //右边去掉一个字符
                for (int i = left, j = right - 1; i < j; i++, j--) {
                    c3 = s.charAt(i);
                    c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }

                //左边去掉一个字符
                for (int i = left + 1, j = right; i < j; i++, j--) {
                    c3 = s.charAt(i);
                    c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
}

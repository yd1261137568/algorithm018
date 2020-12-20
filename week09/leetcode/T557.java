package week09.leetcode;

import java.util.Arrays;

/**
 * 题目:557. 反转字符串中的单词 III
 * 地址:https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
 * 说明:给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 */
public class T557 {
    public static void main(String[] args) {
        String str = "leet code";
        System.out.println(reverseWords(str));
    }

    /**
     * 按单词反转字符串
     * 时间复杂度:O(n)
     * 空间复杂度:O(2n)
     *
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        String[] arr = s.split(" ");

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            char[] chars = arr[i].toCharArray();
            for (int j = 0; j < chars.length / 2; j++) {
                char tmp = chars[j];
                chars[j] = chars[chars.length - j - 1];
                chars[chars.length - j - 1] = tmp;
            }
            sb.append(new String(chars));
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}

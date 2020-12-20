package week09.leetcode;

import java.util.Arrays;

/**
 * 题目:151. 翻转字符串里的单词
 * 地址:https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * 说明:给定一个字符串，逐个翻转字符串中的每个单词。
 */
public class T151 {
    public static void main(String[] args) {
        String str = "leet code";
        System.out.println(reverseWords(str));
    }

    /**
     * 自定义字符数据拼接
     * 时间复杂度:O(n)
     * 空间复杂度:O(2n)
     * @param s
     * @return
     */
    public static String reverseWords(String s) {

        String[] arr = s.trim().split(" ");

        StringBuffer sb = new StringBuffer();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i].length() > 0) {
                sb.append(arr[i]);
                if (i > 0) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
}

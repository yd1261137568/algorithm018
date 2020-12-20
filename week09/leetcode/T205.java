package week09.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目:205. 同构字符串
 * 地址:https://leetcode-cn.com/problems/isomorphic-strings/
 * 说明:给定两个字符串 s 和 t，判断它们是否是同构的。
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 */
public class T205 {
    public static void main(String[] args) {
        String str1 = "7_28]";
        String str2 = "7_28]";
        System.out.println(isIsomorphic(str1, str2));
    }


    /**
     * 同构字符串结构相同
     * 时间复杂度: O(s)
     * 空间复杂度: O(s+t)
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        for (int i = 0; i < s.length(); i++) {

            if (arr1[s.charAt(i)] != arr2[t.charAt(i)]) {
                return false;
            }
            arr1[s.charAt(i)] = i + 1;
            arr2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

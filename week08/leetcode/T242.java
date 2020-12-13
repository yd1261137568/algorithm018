package week08.leetcode;

/**
 * 题目:242. 有效的字母异位词
 * 地址:https://leetcode-cn.com/problems/valid-anagram/
 * 说明:给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class T242 {
    public static void main(String[] args) {
        boolean powerOfTwo = isAnagram("a", "b");
        System.out.println(powerOfTwo);
    }


    /**
     * 计数排序
     * 时间复杂度:O(M+N+26) M N 分别为s、t的长度
     * 空间复杂度:O(26)
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[(s.charAt(i) - 'a')]++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr[(t.charAt(i) - 'a')]--;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;

    }
}

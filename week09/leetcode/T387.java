package week09.leetcode;

/**
 * 题目:387. 字符串中的第一个唯一字符
 * 地址:https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 说明:给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 */
public class T387 {
    public static void main(String[] args) {
        String str = "leetcode";
        int i = firstUniqChar(str);
        System.out.println(i);
    }

    /**
     * 利用数组缓存每个字符出现的次数,然后再遍历一次数组即可
     * 时间复杂度:O(2n)
     * 空间复杂度:O(26)
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {

        char[] arr = new char[26];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            arr[c - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

package week09.leetcode;

/**
 * 题目:541. 反转字符串 II
 * 地址:https://leetcode-cn.com/problems/reverse-string-ii/
 * 说明:给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 */
public class T541 {
    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reverseStr(str, 2));
    }

    /**
     * 每次递增k个,偶数次个反转
     * 时间复杂度:O(n)
     * 空间复杂度:O(1)
     * @param s
     * @param k
     * @return
     */
    public static String reverseStr(String s, int k) {

        char[] chars = s.toCharArray();

        //剩余字符长度
        int size = chars.length;

        //统计反转次数
        int count = 0;

        for (int i = 0; i < chars.length; i += k) {
            if (count % 2 == 0) {
                //反转
                int min = Math.min(size, k * count + k);

                for (int j = k * count, h = min; j < h; j++, h--) {
                    char tmp = chars[j];
                    chars[j] = chars[h - 1];
                    chars[h - 1] = tmp;
                }
            }
            count++;
        }
        return new String(chars);
    }
}

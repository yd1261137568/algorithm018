package week08.leetcode;

/**
 * 题目:191.  位1的个数
 * 地址:https://leetcode-cn.com/problems/number-of-1-bits/
 * 说明:编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）
 */
public class T191 {

    public static void main(String[] args) {
        int i = hammingWeight(11);
        System.out.println(i);
    }


    /**
     * 解法一: 将整数转换为二进制字符串 遍历1的个数
     * 时间复杂度O(1)-O(32)
     * 空间复杂度O(1)-O(32)
     *
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        int count = 0;
        String s = Integer.toBinaryString(n);
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }


    /**
     * 解法二:利用n & (n-1) 最低位置0的操作不断消减二进制位中的1 直到为0
     * 时间复杂度O(1)-O(32)
     * 空间复杂度O(1)
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }
}

package week08.leetcode;

/**
 * 题目:190.  位1的个数
 * 地址:https://leetcode-cn.com/problems/reverse-bits/
 * 说明:颠倒给定的 32 位无符号整数的二进制位。
 */
public class T190 {

    public static void main(String[] args) {
        int i = reverseBits(11);
        System.out.println(i);
    }


    /**
     * 二进制操作按位移动
     * 时间复杂度:O(32)
     * 空间复杂度:O(1)
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }
        return res;
    }
}

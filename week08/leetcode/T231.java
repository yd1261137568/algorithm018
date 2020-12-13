package week08.leetcode;

/**
 * 题目:231.  2的幂
 * 地址:https://leetcode-cn.com/problems/power-of-two/
 * 说明:给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class T231 {
    public static void main(String[] args) {
        boolean powerOfTwo = isPowerOfTwo(-2147483648);
        System.out.println(powerOfTwo);
    }

    /**
     * 利用2的幂 对应二进制只有一个1特性来判断整数是不是2的整数幂,此处需转换long类型 防止越界
     * 时间复杂度:O(1)
     * 空间复杂度:O(1)
     *
     * @param n
     * @return
     */
    public static boolean isPowerOfTwo(int n) {
        long num = n;
        int count = 0;
        while (num != 0) {
            num &= (num - 1);
            if (++count > 1) {
                return false;
            }
        }
        return count == 1 ? true : false;
    }
}

package week04.leetcode;

import java.util.Arrays;

/**
 * 题目:455. 分发饼干
 * 地址:https://leetcode-cn.com/problems/assign-cookies/description/
 * 说明:
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 */
public class T455 {
    public static void main(String[] args) {
        int[] g = {7, 8, 9, 10};
        int[] s = {5, 6, 8, 11};
        int contentChildren = findContentChildren2(g, s);
        System.out.println(contentChildren);
    }

    /**
     * 解法一:贪心 倒着贪
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     * 解题思路
     * 先排序 为最大胃口的小朋友优先分配最大的食物
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {

        //能满足的人数
        int count = 0;
        if (s == null || s.length == 0) {
            return count;
        }

        //先排序
        Arrays.sort(g);
        Arrays.sort(s);

        //当前分发饼干下标
        int j = s.length - 1;

        for (int i = g.length - 1; i >= 0 && j >= 0; i--) {
            //为i个小朋友分发的饼干分量
            if (s[j] < g[i]) {
                continue;
            }
            j--;
            count++;
        }
        return count;
    }

    /**
     * 解法而:贪心 正着贪
     * 时间复杂度: O(logn)
     * 空间复杂度: O(1)
     * 解题思路
     * 先排序 为最大小口的小朋友优先分配最小的食物,如果满足不了 拿比当前食物大一点的食物继续分配,直到满足为止,如果最大的食物还满足不了最小的小朋友 返回0
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren2(int[] g, int[] s) {
        //能满足的人数
        int count = 0;
        if (s == null || s.length == 0) {
            return count;
        }

        //先排序
        Arrays.sort(g);
        Arrays.sort(s);

        //当前分发饼干下标
        int j = 0;

        for (int i = 0; i < g.length && j < s.length; i++) {
            //从小分配 直到取出满足的食物 或者取到最大食物
            while (s[j] < g[i] && j < s.length - 1) {
                j++;
            }
            if (s[j] < g[i]) {
                continue;
            }
            j++;
            count++;
        }
        return count;
    }
}


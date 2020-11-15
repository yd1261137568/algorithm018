package week04.leetcode;

import org.junit.Test;

/**
 * 题目:860. 柠檬水找零
 * 地址:https://leetcode-cn.com/problems/lemonade-change/
 * 说明:
 * 在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
public class T860 {

    public static void main(String[] args) {
        boolean b = lemonadeChange(new int[]{5, 5, 10});
        System.out.println(b);
    }

    /*
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 解题思路:
     * 由于只有5 10 20 且20元三种额度的货币,那么就会有如下三种情况
     * 1.收到5元   不用找零                 需用变量存储现有5元的个数
     * 2.收到10元  只能找零5元              需用变量存储现有10元的个数
     * 3.收到20元  优先10元找零 再用5元找零  收到20元后无需用20找零,只进不出,所以无需保留20元的个数
     */
    public static boolean lemonadeChange(int[] bills) {

        //5元个数
        int five = 0;
        //10元个数
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {//收到5元
                five++;
            } else if (bill == 10) {//收到10元
                if (five > 0) {
                    ten++;
                    five--;
                } else {
                    return false;
                }
            } else {//收到20元
                if (ten > 0) {
                    ten--;
                    if (five > 0) {
                        five--;
                    } else {
                        return false;
                    }
                } else {
                    if (five > 2) {
                        five -= 3;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

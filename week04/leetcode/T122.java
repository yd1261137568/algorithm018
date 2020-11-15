package week04.leetcode;


/**
 * 题目:122. 买卖股票的最佳时机 II
 * 地址:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 说明:
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class T122 {
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        int i = maxProfit3(arr);
        System.out.println(i);

    }

    /**
     * 解法一:暴力回溯  leetcode运行超时
     * 时间复杂度: O(2^n)
     * 空间复杂度: O(logn)
     * 解题思路
     * 第一天 : 只能选择买入或者不买
     * 随后n天 : 根据当天持股状态
     * 持股:卖出 | 不卖
     * 现金:买入 | 不买
     *
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {

        if (prices == null) {
            return 0;
        }

        dfs(prices, 0, 0, 0);

        return result;
    }

    static int result = 0;

    /**
     * @param prices
     * @param state  持股状态 0 现金  1股票
     * @param depth  持股第 n-1 天  递归深度
     * @param money  持股现金
     */
    private static void dfs(int[] prices, int state, int depth, int money) {
        //递归结束条件
        if (depth >= prices.length) {
            if (money > result) {
                result = money;
            }
            return;
        }

        //处理逻辑
        if (state == 0) {
            //买入
            dfs(prices, 1, depth + 1, money - prices[depth]);
            //不买
            dfs(prices, 0, depth + 1, money);

        } else {
            //卖出
            dfs(prices, 0, depth + 1, money + prices[depth]);
            //不卖
            dfs(prices, 1, depth + 1, money);
        }
    }


    /**
     * 解法二:动态规划
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 解题思路:
     * 现有收益只能是上一次股票卖出的收益
     * 现有股票只能是上一次收益买入的股票
     * 会涉及一些贪心 只有操作有益 才继续下一步操作,否则什么也不做
     * 由此建立状态转移方程
     *
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {

        //特殊值处理
        if (prices == null) {
            return 0;
        }

        //现有收益
        int money = 0;
        //现有持股
        int shares = -prices[0];

        for (int i = 1; i < prices.length; i++) {

            //现有收益= max(出售上次买入的股票,不买)
            int moneyNew = Math.max(shares + prices[i], money);
            //现有股票=max(上次收益-股票价格,不卖)
            int sharesNew = Math.max(money - prices[i], shares);

            money = moneyNew;
            shares = sharesNew;
        }

        return money;
    }


    /**
     * 解法三:贪心
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 解题思路:
     * 只要能赚钱就发生交易
     *
     * @param prices
     * @return
     */
    public static int maxProfit3(int[] prices) {

        int money = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                money += prices[i] - prices[i - 1];
            }
        }
        return money;
    }
}

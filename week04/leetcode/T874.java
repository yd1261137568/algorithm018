package week04.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 题目:874. 模拟行走机器人
 * 地址:https://leetcode-cn.com/problems/walking-robot-simulation/
 * 说明:
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 */
public class T874 {
    public static void main(String[] args) {
        int[] commands = {4, -1, 3};
        int[][] obstacles = {{2, 4}};
        int i = robotSim(commands, obstacles);
        System.out.println(i);
    }

    public static int robotSim(int[] commands, int[][] obstacles) {

        //坐标
        int x = 0;
        int y = 0;

        //距离
        int ans = 0;

        //朝向 0:北 1:东 2:南 3:西
        int direction = 0;

        //每个朝向上的数据变化
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        HashSet<String> set = new HashSet<>();

        //将所有障碍物坐标组合成字符串存入set中方便查询
        for (int[] arr : obstacles) {
            set.add(arr[0] + "，" + arr[1]);
        }

        for (int com : commands) {
            //定义下一步的坐标
            int nextX = 0, nextY = 0;

            //开始移动
            if (com >= 0) {
                for (int i = 0; i < com; i++) {
                    //获取新坐标
                    nextX = x + directions[direction][0];
                    nextY = y + directions[direction][1];
                    //遇到障碍 结束
                    if (set.contains(nextX + "，" + nextY)) {
                        break;
                    }
                    //否则更新坐标与最远距离
                    x = nextX;
                    y = nextY;
                    ans = Math.max(ans, x * x + y * y);
                }
            } else {
                //改变朝向  直接写三元运算
                direction = com == -1 ? (direction + 1) % 4 : (direction + 3) % 4;
            }
        }
        return ans;
    }

}

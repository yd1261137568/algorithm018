package week08.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 题目:56.  合并区间
 * 地址:https://leetcode-cn.com/problems/merge-intervals/
 * 说明:给出一个区间的集合，请合并所有重叠的区间。
 */
public class T56 {
    public static void main(String[] args) {
        int[][] arrs = {{459, 467}, {8, 22}, {71, 90}, {270, 287}, {419, 425}, {51, 68}, {134, 148}, {103, 117}, {478, 479}, {182, 200}, {493, 493}, {49, 51}, {416, 427}, {360, 378}, {413, 430}, {401, 414}, {318, 328}, {159, 168}, {61, 70}, {198, 199}, {276, 285}, {370, 372}, {183, 188}, {16, 30}, {158, 169}, {344, 355}, {131, 145}, {286, 294}, {285, 303}, {438, 449}, {395, 395}, {424, 429}, {102, 105}, {454, 457}, {365, 377}, {496, 509}, {253, 259}, {255, 264}, {44, 56}, {155, 157}, {323, 342}, {206, 220}, {245, 257}, {354, 365}, {342, 355}, {82, 91}, {133, 151}, {155, 162}, {293, 302}, {250, 268}, {114, 121}, {151, 170}, {465, 484}, {8, 17}, {31, 34}, {212, 218}, {15, 33}, {12, 12}, {262, 281}, {143, 147}, {12, 29}, {193, 210}, {435, 443}, {84, 85}, {310, 316}, {239, 255}, {433, 436}, {495, 514}, {2, 6}, {260, 265}, {19, 31}, {443, 457}, {242, 249}, {147, 151}, {26, 36}, {460, 470}, {220, 234}, {239, 246}, {354, 369}, {88, 104}, {362, 362}, {292, 307}, {275, 283}, {46, 55}, {144, 151}, {366, 369}, {131, 140}, {50, 64}, {468, 485}, {378, 385}, {339, 358}, {237, 248}, {345, 362}, {419, 430}, {152, 171}, {68, 74}, {39, 39}, {162, 176}, {0, 0}, {295, 299}, {219, 220}};
        for (int[] ints : merge(arrs)) {
            System.out.println(ints[0] + "\t" + ints[1]);
        }
        ;
    }

    /**
     * 先对左端点进行排序 排完序合并数据
     * 时间复杂度:O(nlongn)
     * 空间复杂度;O(n)
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {

        //异常值处理
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        //首先对二维数据的左端点进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] - o2[0]) == 0 ? (o1[1] - o2[1]) : (o1[0] - o2[0]);
            }
        });


        //创建新数组
        int[][] arrs = new int[intervals.length][2];
        int index = 0;


        //合并数据
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] < intervals[i + 1][0]) {
                arrs[index++] = intervals[i];

                if (i == intervals.length - 2) {
                    arrs[index++] = intervals[i + 1];
                }

            } else {

                if (i == intervals.length - 2) {
                    arrs[index++] = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])};
                } else {
                    intervals[i + 1] = new int[]{intervals[i][0], Math.max(intervals[i][1], intervals[i + 1][1])};
                }
            }
        }

        return Arrays.copyOf(arrs, index);

    }
}

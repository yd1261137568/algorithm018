package week08.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 题目:1122.  数组的相对排序
 * 地址:https://leetcode-cn.com/problems/relative-sort-array/
 * 说明:给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 */
public class T1122 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        for (int i : relativeSortArray(arr1, arr2)) {
            System.out.println(i);
        }
        ;
    }

    /**
     * 计数排序
     * 时间复杂度:O(M+M+1001)
     * 空间复杂度:O(1001)
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] arr = new int[1001];

        for (int i : arr1) {
            arr[i]++;
        }

        int index = 0;

        for (int i : arr2) {
            for (int j = 0; j < arr[i]; j++) {
                arr1[index++] = i;
            }
            arr[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                arr1[index++] = i;
            }
        }
        return arr1;

    }
}

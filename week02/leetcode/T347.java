package week02.leetcode;

import java.util.*;

public class T347 {
    public static void main(String[] args) {
        for (int i : topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)) {
            System.out.println(i);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> integers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            integers.add(entry.getKey());
        }

        int[] ints = new int[k];
        for (int i = 0; i < k; i++) {
            ints[i] = integers.poll();
        }

        return ints;
    }
}

package week01.leetcode;

import java.util.HashMap;
import java.util.Map;

public class T1 {
    public static void main(String[] args) {
        int[] nums ={2,7,11,15};
        int[] ints = twoSum(nums, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }


    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[2];
    }
}

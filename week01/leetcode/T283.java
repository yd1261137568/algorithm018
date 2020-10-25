package week01.leetcode;

public class T283 {
    public static void main(String[] args) {
        int[] nums ={0,1,0,3,12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }

    }

    public static void moveZeroes(int[] nums) {
        if(nums==null) {
            return;
        }

        int j = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0 ){
                if(j>=i){
                    j++;
                }else{
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j++] = tmp;
                }
            }

        }
    }
}

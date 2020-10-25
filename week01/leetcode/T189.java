package week01.leetcode;

public class T189 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        rotate(arr,3);

        for (int i : arr) {
            System.out.println(i);
        }

    }

    public static void rotate(int[] nums, int k) {
        //当k超出数据长度是取模
        if(k>nums.length){
            k=k%nums.length;
        }


        //1.反转数组
        int tmp = 0;
        for(int i=0;i<nums.length/2;i++){
            tmp=nums[i];
            nums[i]=nums[nums.length-i-1];
            nums[nums.length-i-1]=tmp;
        }

        //2.反转前k位
        for(int i=0;i<k/2;i++){
            tmp=nums[i];
            nums[i]=nums[k-i-1];
            nums[k-i-1]=tmp;
        }

        //3.反转nums.length-k位
        for(int i=k;i<(nums.length-k)/2+k;i++){
            tmp=nums[i];
            nums[i]=nums[nums.length-i-1+k];
            nums[nums.length-i-1+k]=tmp;
        }

    }
}

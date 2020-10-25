package week01.leetcode;

public class T66 {
    public static void main(String[] args) {
        int[] nums ={1,2,9};
        for (int i : plusOne(nums)) {
            System.out.println(i);
        }


    }

    public static int[] plusOne(int[] digits) {

            for(int i=digits.length-1;i>0;i--){
                digits[i]++;
                digits[i] %= 10;
                if(digits[i]!=0){
                    return  digits;
                }
            }

        return digits;
    }


}

package week01.leetcode;

public class T42 {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {

        if (height == null || height.length == 1) {
            return 0;
        }

        //双指针遍历接雨水
        //1.定双义指针及雨水
        int left = 0;
        int right = height.length - 1;
        int num = 0;

        //2.定义左右单块最大值
        int left_max = 0;
        int rigth_max = 0;

        while (left < right) {
            if (height[left] < height[right]) {

                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    num += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > rigth_max) {
                    rigth_max = height[right];
                } else {
                    num += rigth_max - height[right];
                }
                right--;
            }
        }

        return num;

    }
}

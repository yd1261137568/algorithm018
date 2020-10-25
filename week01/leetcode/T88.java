package week01.leetcode;

public class T88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};

        merge2(nums1,3,nums2,3);
    }

    /**
     * 时间复杂度 O(2m+2n) ==> O(n)
     * 空间复杂度 O<m+n> => O(n)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //1.创建一个新数组
        int[] nums3 = new int[m+n];

        //2.定义两个指针
        int i=0;
        int j=0;

        //3.分情况后移指针 把最小值塞入新数组
        for(int k=0;k<m+n;k++){
            if(i<m&&j<n){
                if(nums1[i]<nums2[j]){
                    nums3[k]=nums1[i++];
                }else if(nums1[i]>nums2[j]){
                    nums3[k]=nums2[j++];
                }else{
                    nums3[k++]=nums1[i++];
                    nums3[k]=nums2[j++];
                }
            }else if(i>=m&&j<n){
                nums3[k]=nums2[j++];
            }else if(i<m&&j>=n){
                nums3[k]=nums1[i++];
            }

        }

        //此操作leetcode不行
//        nums1 = nums3;


        for(int k=0;k<nums3.length;k++){
            nums1[k]=nums3[k];
        }
    }

    /**
     * 从后往前遍历 利用nums1 后续剩余空间避免新数组开辟
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {


        //1.定义两个指针
        int i=m-1;
        int j=n-1;

        //2.分情况后移指针 把最小值塞入新数组
        for(int k=m+n-1;k>=0;k--){
            if(i>=0&&j>=0){
                if(nums1[i]>nums2[j]){
                    nums1[k]=nums1[i--];
                }else if(nums1[i]<nums2[j]){
                    nums1[k]=nums2[j--];
                }else{
                    nums1[k--]=nums1[i--];
                    nums1[k]=nums2[j--];
                }
            }else if(i<0&&j>=0){
                nums1[k]=nums2[j--];
            }else if(i>=0&&j<0){
                nums1[k]=nums1[i--];
            }

        }

//        for (int i1 : nums1) {
//            System.out.println(i1);
//        }

    }
}

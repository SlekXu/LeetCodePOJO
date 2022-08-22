package labuladong.Array;

public class LC_27 {


    /**
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,4,0,3]
     */
    public int removeElement(int[] nums, int val) {     //左右指针法
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];       //把尾部的值塞到left上
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

    public int removeElement2(int[] nums, int val) {     //快慢指针法
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == val) {   //fast遇到val的值，直接忽略

            } else {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }

        return left;
    }


}

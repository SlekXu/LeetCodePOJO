package labuladong.Array;


/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */

public class LC_283 {


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return;
        }

        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] == 0) {
                if (nums[right] != 0) {
                    swap(nums, left, right);
                    left++;
                }
            } else {
                left++;
            }
            right++;
        }
    }


    private static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}

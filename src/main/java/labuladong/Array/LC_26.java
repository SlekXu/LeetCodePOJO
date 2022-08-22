package labuladong.Array;

/**
 * 删除有序数组中的重复项
 * 不使用额外的空间，且原地修改
 */
public class LC_26 {

    /**
     * 数组已经有序，快慢指针:用fast去替换掉slow的
     * [0,0,1,1,1,2,2,3,3,4]返回5
     * [0,1,2,3,4]
     */
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[slow] != nums[fast]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
        }
        return slow + 1;
    }
}

package labuladong.Array;


import java.text.BreakIterator;

/**
 * 两数之和
 */
public class LC_167 {

    /**
     * 左右指针
     */
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        int left = 0;
        int right = length - 1;

        int[] result = new int[2];
        while (left < right) {
            int tmpSum = numbers[left] + numbers[right];
            System.out.println(tmpSum);
            if (tmpSum < target) {
                left++;
            } else if (tmpSum > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        LC_167 obj = new LC_167();
        obj.twoSum(nums, 9);
    }

}

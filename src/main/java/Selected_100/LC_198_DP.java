package Selected_100;

import org.junit.Test;

//非连续和的最大值
public class LC_198_DP {


    //DP[i]是以num[i]为结尾的最大值，递推公式如下：
    //DP[i] = Max(DP[i-2]+nums[i],  DP[i-1])
    //要么就隔着把本间房也偷了；要么就本间房不偷（取前一个值）
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] DP = new int[length];
        DP[0] = nums[0];
        DP[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            DP[i] = Math.max(DP[i - 2] + nums[i], DP[i - 1]);
        }
        return DP[length - 1];  //因为均为非负整数，必然递增
    }


    @Test
    public void test() {

        int[] house2 = new int[]{2, 1, 1, 2};

        System.out.println(rob(house2));
    }
}

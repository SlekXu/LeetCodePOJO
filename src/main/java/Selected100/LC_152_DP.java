package Selected100;


import org.junit.Test;

//乘积最大连续非空的子数组
public class LC_152_DP {

    /**
     * 动态规划
     * DPmax[i]是以i为结尾的连续子数组乘机的最大值
     * —— 正常求 DPmax[i] = Max(DPmax[i]*nums[i], nums[i])
     * —— 如果nums[i]为负数，则最小值会变成最大值
     */
    public int maxProduct(int[] nums) {
        int res_max = Integer.MIN_VALUE;
        int tmp_max = 1;
        int tmp_min = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {      //如果nums[i]<0，则最大最小值反转
                int tmp = tmp_max;
                tmp_max = tmp_min;
                tmp_min = tmp;
            }
            tmp_max = Math.max(tmp_max * nums[i], nums[i]);
            tmp_min = Math.min(tmp_min * nums[i], nums[i]);

            res_max = Math.max(res_max, tmp_max);
        }
        return res_max;
    }


    @Test
    public void test() {
        int[] nums = new int[]{2, 3, -2, 4};


    }
}

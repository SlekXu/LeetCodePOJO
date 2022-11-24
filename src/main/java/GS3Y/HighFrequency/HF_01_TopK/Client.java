package GS3Y.HighFrequency.HF_01_TopK;

import org.junit.Test;

/**
 * @Author Slek
 * @Date 2022/11/7 22:48
 * @Description
 */
public class Client {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 8, 5, 2};
        KthLargest obj = new KthLargest(3, nums);
    }
}

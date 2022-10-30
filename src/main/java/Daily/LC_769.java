package Daily;

import org.junit.Test;

/**
 * @Author Slek
 * @Date 2022/10/13 23:01
 * @Description 最多能完成排序的块
 */
public class LC_769 {

    /**
     * 遍历数组，如果是升序的则断开，如果是降序的则继续
     */
    public int maxChunksToSorted(int[] arr) {
        int res = 1;
        if (arr.length == 1) return res;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                res += 1;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] array = new int[]{2, 0, 1};
        System.out.println(maxChunksToSorted(array));
    }
}

package GS3Y.HighFrequency.HF_01_TopK;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author Slek
 * @Date 2022/10/27 22:53
 * @Description 数据流中的第K大元素的类
 */
public class KthLargest {

    private
    int k;
    private PriorityQueue<Integer> queue;

    public KthLargest(int _k, int[] _nums) {
        k = _k;
        queue = new PriorityQueue<>(k, (a, b) -> Integer.compare(a, b));    //队首到队尾是正序的
        int n = _nums.length;
        for (int i = 0; i < k && i < n; i++) queue.add(_nums[i]);
        System.out.println(queue);
//        for (int i = k; i < n; i++) add(_nums[i]);
    }

    public int add(int val) {
        int top = (!queue.isEmpty()) ? queue.peek() : Integer.MIN_VALUE;
        if (val > top || queue.size() < k) {
            if (!queue.isEmpty() && queue.size() >= k) {    //优先级队列只保存K个
                queue.poll();
            }
            queue.add(val);
        }

        return queue.peek();
    }


    @Test
    public void  test(){

    }
}



package Selected100;

import sun.rmi.runtime.Log;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//多数元素
public class LC_169 {

    public int majorityElement(int[] nums) {
        int threadHold = nums.length >> 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (record.getOrDefault(nums[i], 1) > threadHold) {
//                return nums[i];
//            }
//            if (record.get(nums[i]) == null) {
//                record.put(nums[i], 1);
//            } else {
//                record.put(nums[i], record.get(nums[i]) + 1);
//            }
//        }

        Map<Integer, Long> record = Arrays.stream(nums).boxed()         //先转化为List
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));


        for (Map.Entry<Integer, Long> entry : record.entrySet()) {
            if (entry.getValue() > threadHold) {
                return entry.getKey();
            }
        }
        return -1;
    }
}

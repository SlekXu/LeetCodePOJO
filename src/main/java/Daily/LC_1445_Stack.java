package Daily;

import org.junit.Test;

import java.time.DayOfWeek;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Slek
 * @Date 2022/9/1 13:11
 * @Description 商品折扣后的最终价格
 * j < i，且price[j] <= price[i]
 * 最终价格为price[i]-price[j]
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 */
public class LC_1445_Stack {

    /**
     * 两层for循环
     */
    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int tmpMin = prices[i + 1];
            for (int j = i + 1; j < prices.length; j++) {   //j为满足条件的最小下标
                if (prices[j] <= prices[i]) {
                    tmpMin = prices[j];
                    break;
                }
            }

            res[i] = (tmpMin > prices[i]) ? prices[i] : (prices[i] - tmpMin);
        }
        return res;
    }

    /**
     * 依靠单调栈
     * 输入：prices = [8,4,6,2,3]
     * 输出：[4,2,4,2,3]
     * 思路：
     * 容器(递增单调栈)，记录的是带打折的商品的下标索引
     * 1、假设遍历到price[i]，它比容器(递增单调栈)内的任意元素都要大，那么它无法给容器内的商品打折，把它加到容器尾部
     * 2、如果price[i]价格不都高于容器内元素的价格（用容器尾部的元素比较），那么它能够给容器内的商品打折
     * 因为容器是从头到尾递增的，所以从尾部取出待打折商品进行更新，直到遇到第一个无法更新价格的商品
     * —— 可能存在某个元素多次更新的场景
     */
    public int[] finalPrices_Stack(int[] prices) {
        int num = prices.length;
        int[] res = new int[num];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num; i++) {
            while (!stack.isEmpty() && prices[stack.peekLast()] >= prices[i]) {
                //当前商品的价格比（单调递增栈）stack尾部的元素小，说明当前i的价格能够更新stack中元素的价格(持续更新，直到不能更新为止)
                int index = stack.pollLast();
                res[index] = prices[index] - prices[i];
            }
            //栈为空，或者当前元素的价格比stack尾部的元素的价格还要大（当前元素已经对stack内元素的价格更新无能为力了）
            stack.addLast(i);   //加入栈尾
            res[i] = prices[i];
        }
        return res;
    }


    @Test
    public void test() {
        int[] prices = new int[]{8, 4, 6, 2, 3};
        int[] res = prices;
        System.out.println(prices.equals(res));
    }

}

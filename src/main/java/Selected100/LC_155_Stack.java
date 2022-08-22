package Selected100;

import java.util.Stack;

//设计一个支持push, pop, top操作的，并能够在常数时间范围内检索到最小元素的栈
public class LC_155_Stack {

    //使用一个辅助栈min_stack，记录栈顶元素为最小值
    class MinStack {

        private Stack<Integer> act_stack;       //实际栈
        private Stack<Integer> min_stack;       //辅助用的最小栈（自顶向底，降序）

        public MinStack() {
            this.act_stack = new Stack<>();
            this.min_stack = new Stack<>();
        }

        //实际栈正常推入
        //如果当前值小于min_stack的最小值，则直接推入该值到min_stack
        public void push(int val) {
            act_stack.push(val);
            if (min_stack.isEmpty() || val <= min_stack.peek()) {
                min_stack.push(val);
            }
        }

        //实际栈正常弹出
        //如果当前值等于min_stack的栈顶元素（最小值），则min_stack也需要弹出
        public void pop() {
            if (act_stack.peek().equals(min_stack.peek())) {
                min_stack.pop();
            }
            act_stack.pop();

        }

        public int top() {
            return act_stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }

}

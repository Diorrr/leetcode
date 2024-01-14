package problems.medium.stack;


import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/min-stack">
 * min-stack</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution155 {
    class MinStack {

        Stack<Integer> stack;
        PriorityQueue<Integer> queue;

        public MinStack() {
            stack = new Stack<>();
            queue = new PriorityQueue<>();
        }

        public void push(int val) {
            stack.push(val);
            queue.offer(val);
        }

        public void pop() {
            queue.remove(stack.pop());
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return queue.peek();
        }
    }
}

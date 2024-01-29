package problems.easy.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/implement-queue-using-stacks">
 * implement-queue-using-stacks</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution232 {
    class MyQueue {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> queue = new Stack<>();

        public MyQueue() {
            stack = new Stack<>();
            queue = new Stack<>();
        }

        public void push(int x) {
            stack.add(x);
        }

        public int pop() {
            peek();
            return queue.pop();
        }

        public int peek() {
            if (queue.isEmpty()) {
                while (!stack.isEmpty()) {
                    queue.add(stack.pop());
                }
            }
            return queue.peek();
        }

        public boolean empty() {
            return stack.isEmpty() && queue.isEmpty();
        }
    }
}

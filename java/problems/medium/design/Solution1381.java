package problems.medium.design;


import java.util.LinkedList;

/**
 * Problem: <a href="https://leetcode.com/problems/design-a-stack-with-increment-operation">
 * design-a-stack-with-increment-operation</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1381 {
    class CustomStack {
        int[] list;
        int index;

        public CustomStack(int maxSize) {
            this.list = new int[maxSize];
            this.index = -1;
        }

        public void push(int x) {
            if (index < list.length) {
                index = (index + 1 + list.length) % list.length;
                list[index] = x;
            }
        }

        public int pop() {
            if (index == -1) {
                return -1;
            }
            int res = list[index];
            index = (index - 1 + list.length) % list.length;
            return res;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, index); i++) {
                list[i] += val;
            }
        }
    }

    class CustomStack2 {
        LinkedList<Integer> list = new LinkedList<>();
        int maxSize;

        public CustomStack2(int maxSize) {
            this.maxSize = maxSize;
        }

        public void push(int x) {
            if (list.size() < maxSize) {
                list.addLast(x);
            }
        }

        public int pop() {
            if (list.isEmpty()) {
                return -1;
            }
            int res = list.getLast();
            list.removeLast();
            return res;
        }

        public void increment(int k, int val) {
            for (int i = 0; i < Math.min(k, list.size()); i++) {
                list.set(i, list.get(i) + val);
            }
        }
    }
}

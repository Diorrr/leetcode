package problems.leetcode.easy.queue;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-students-unable-to-eat-lunch">
 * number-of-students-unable-to-eat-lunch</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        int sandwichIndex = 0;
        boolean isChanged = true;
        for (int student : students) {
            queue.add(student);
        }
        while (isChanged) {
            isChanged = false;
            int studentsSize = queue.size();
            while (studentsSize-- > 0) {
                int student = queue.poll();
                if (student == sandwiches[sandwichIndex]) {
                    sandwichIndex++;
                    isChanged = true;
                } else {
                    queue.add(student);
                }
            }
        }

        return queue.size();
    }
}

package problems.leetcode.util;

import java.util.LinkedList;
import java.util.Queue;

public class Util {
    public static TreeNode createFromArray(Integer[] arr) {
        if (arr != null && arr.length > 0) {
            TreeNode root = new TreeNode(arr[0]);
            int index = 1;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty() && index < arr.length) {
                TreeNode curr = queue.poll();
                if (curr != null) {
                    if (arr[index] != null) {
                        curr.left = new TreeNode(arr[index]);
                        queue.add(curr.left);
                    }
                    index++;
                    if (index < arr.length && arr[index] != null) {
                        curr.right = new TreeNode(arr[index]);
                        queue.add(curr.right);
                    }
                    index++;
                }
            }
            return root;
        }

        return null;
    }
}

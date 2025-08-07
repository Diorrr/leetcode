package problems.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure">
 * design-add-and-search-words-data-structure</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution211 {
    class WordDictionary {
        Node root;

        public WordDictionary() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new Node());
                curr = curr.children.get(c);
            }
            curr.isEndOfWord = true;
        }

        public boolean search(String word) {
            return isExists(root, word, 0);
        }

        private boolean isExists(Node root, String word, int index) {
            if (root == null) {
                return false;
            }
            if (word.length() == index) {
                return root.isEndOfWord;
            }
            boolean isReachable = false;
            if (word.charAt(index) == '.') {
                for (Node child : root.children.values()) {
                    isReachable |= isExists(child, word, index + 1);
                }
            }
            return isReachable || isExists(root.children.get(word.charAt(index)), word, index + 1);
        }

        static class Node {
            boolean isEndOfWord = false;
            Map<Character, Node> children;

            public Node() {
                children = new HashMap<>();
            }
        }
    }
}

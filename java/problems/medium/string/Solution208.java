package problems.medium.string;

import java.util.HashSet;
import java.util.Set;

class Solution208 {
    /**
     * Problem: https://leetcode.com/problems/implement-trie-prefix-tree/
     * Time Complexity:
     * Space Complexity：
     */

    class Node {
        public boolean isWord = false;
        public Node[] children = new Node[26];

        public Node() {
        }
    }

    class Trie {
        Node root;
        Set<String> words;

        public Trie() {
            root = new Node();
            words = new HashSet<>();
        }

        public void insert(String word) {
            words.add(word);
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                if (curr.children[word.charAt(i) - 'a'] == null) {
                    curr.children[word.charAt(i) - 'a'] = new Node();
                }
                curr = curr.children[word.charAt(i) - 'a'];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return words.contains(word);
        }

        public boolean startsWith(String prefix) {
            Node curr = root;
            for (int i = 0; curr != null && i < prefix.length(); i++) {
                curr = curr.children[prefix.charAt(i) - 'a'];
            }

            return curr != null;
        }
    }

    class Trie2 {
        Set<String> prefixSet;

        Set<String> words;

        public Trie2() {
            prefixSet = new HashSet<>();
            words = new HashSet<>();
        }

        public void insert(String word) {
            words.add(word);
            for (int i = 1; i < word.length() + 1; i++) {
                prefixSet.add(word.substring(0, i));
            }
        }

        public boolean search(String word) {
            return words.contains(word);
        }

        public boolean startsWith(String prefix) {
            return prefixSet.contains(prefix);
        }
    }
}

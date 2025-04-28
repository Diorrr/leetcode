package problems.medium.string;


import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/simplify-path">
 * simplify-path</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution71 {
    public String simplifyPath(String path) {
        String[] folders = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String folder : folders) {
            if (!folder.isEmpty() && !folder.equals(".")) {
                if (!folder.equals("..")) {
                    list.add(folder);
                } else if (!list.isEmpty()) {
                    list.removeLast();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String folder : list) {
            sb.append("/").append(folder);
        }
        return sb.isEmpty() ? "/" : sb.toString();
    }

    public String simplifyPath1(String path) {
        Deque<String> deque = new LinkedList<>();
        Set<String> set = new HashSet<>(List.of("", ".", ".."));
        char[] pathChar = path.toCharArray();
        for (int i = 0; i < pathChar.length; i++) {
            if (pathChar[i] == '/') {
                continue;
            }
            StringBuilder dir = new StringBuilder();
            while (i < pathChar.length && pathChar[i] != '/') {
                dir.append(pathChar[i++]);
            }
            if (dir.toString().equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!set.contains(dir.toString())) {
                deque.add(dir.toString());
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.removeFirst());
        }
        return sb.toString();
    }

    public String simplifyPath2(String path) {
        List<String> res = new ArrayList<>();
        while (path.contains("//")) {
            path = path.replace("//", "/");
        }
        char[] pathChar = path.toCharArray();

        int nextSlash;
        int pos = 0;
        while (pos < pathChar.length) {
            for (nextSlash = pos + 1; nextSlash < pathChar.length; nextSlash++) {
                if (pathChar[nextSlash] == '/') {
                    break;
                }
            }
            String dir = path.substring(pos + 1, nextSlash);

            if (dir.equals("..")) {
                if (!res.isEmpty()) {
                    res.remove(res.size() - 1);
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                res.add(dir);
            }
            pos = nextSlash;
        }

        return res.isEmpty() ? "/" : res.stream().reduce("", (a, b) -> a + "/" + b);
    }
}

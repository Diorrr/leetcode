package problems.medium.string;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/simplify-path">
 * simplify-path</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution71 {
    public String simplifyPath(String path) {
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
